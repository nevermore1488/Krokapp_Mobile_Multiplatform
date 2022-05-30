package by.ssrlab.krokapp.mobile.android.di

import android.content.Context
import by.ssrlab.krokapp.mobile.shared.cache.AppDatabase
import by.ssrlab.krokapp.mobile.shared.cache.AppDatabaseQueries
import by.ssrlab.krokapp.mobile.shared.data.api.services.CitiesApiService
import by.ssrlab.krokapp.mobile.shared.data.repos.CitiesRepositoryImpl
import by.ssrlab.krokapp.mobile.shared.domain.repos.CitiesRepository
import by.ssrlab.krokapp.mobile.shared.domain.usecases.GetCitiesUseCase
import by.ssrlab.krokapp.mobile.shared.presentation.viewmodels.CitiesViewModel
import com.squareup.sqldelight.android.AndroidSqliteDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideCitiesViewModel(
        getCitiesUseCase: GetCitiesUseCase
    ): CitiesViewModel {
        return CitiesViewModel(getCitiesUseCase)
    }

    @Provides
    fun provideGetCitiesUseCase(
        citiesRepository: CitiesRepository
    ): GetCitiesUseCase {
        return GetCitiesUseCase(citiesRepository)
    }

    @Provides
    fun provideCitiesRepository(
        citiesApiService: CitiesApiService,
        citiesDao: AppDatabaseQueries
    ): CitiesRepository {
        return CitiesRepositoryImpl(citiesApiService, citiesDao)
    }

    @Provides
    fun provideCitiesApiService(
        apiClient: HttpClient
    ): CitiesApiService {
        return CitiesApiService(apiClient, "https://krokapp.by/api")
    }

    @Provides
    fun provideHttpClient(): HttpClient {
        return HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    },
                    contentType = ContentType.Any
                )
            }
        }
    }

    @Provides
    fun provideAppDatabaseQueries(
        appDatabase: AppDatabase
    ): AppDatabaseQueries {
        return appDatabase.appDatabaseQueries
    }

    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return AppDatabase(AndroidSqliteDriver(AppDatabase.Schema, context, "app.db"))
    }
}
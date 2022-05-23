package by.ssrlab.krokapp.mobile.android.di

import by.ssrlab.krokapp.mobile.shared.data.api.services.CitiesApiService
import by.ssrlab.krokapp.mobile.shared.data.mappers.CitiesApiMapper
import by.ssrlab.krokapp.mobile.shared.data.repos.CitiesRepositoryImpl
import by.ssrlab.krokapp.mobile.shared.domain.repos.CitiesRepository
import by.ssrlab.krokapp.mobile.shared.domain.usecases.GetCitiesUseCase
import by.ssrlab.krokapp.mobile.shared.presentation.viewmodels.CitiesViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
        citiesApiMapper: CitiesApiMapper
    ): CitiesRepository {
        return CitiesRepositoryImpl(citiesApiService, citiesApiMapper)
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
    fun provideCitiesApiMapper(): CitiesApiMapper {
        return CitiesApiMapper()
    }
}
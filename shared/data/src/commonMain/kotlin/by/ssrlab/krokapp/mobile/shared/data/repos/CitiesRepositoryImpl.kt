package by.ssrlab.krokapp.mobile.shared.data.repos

import by.ssrlab.krokapp.mobile.shared.cache.AppDatabaseQueries
import by.ssrlab.krokapp.mobile.shared.cache.CityRaw
import by.ssrlab.krokapp.mobile.shared.data.api.services.CitiesApiService
import by.ssrlab.krokapp.mobile.shared.data.entities.CityApi
import by.ssrlab.krokapp.mobile.shared.domain.entities.City
import by.ssrlab.krokapp.mobile.shared.domain.repos.CitiesRepository
import com.squareup.sqldelight.runtime.coroutines.asFlow
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

/**
 * @author Alexander Nevertovich
 */
class CitiesRepositoryImpl(
    private val citiesApiService: CitiesApiService,
    private val citiesDao: AppDatabaseQueries,
    private val ioDispatcher: CoroutineDispatcher
) : CitiesRepository {

    override suspend fun getCities(): Flow<List<City>> {
        withContext(ioDispatcher) {
            val citiesFromDb = citiesDao.selectAllCities().executeAsList()

            if (citiesFromDb.isNullOrEmpty()) {
                val citiesFormApi = citiesApiService.getCities()

                citiesDao.transaction {
                    citiesDao.removeAllCities()

                    citiesFormApi.forEach {
                        citiesDao.insertCity(it.toRaw())
                    }
                }
            }
        }

        return citiesDao.selectAllCities().asFlow().map {
            it.executeAsList().map { it.toEntity() }
        }
    }

    private fun CityApi.toRaw() = CityRaw(
        id = id_locale,
        city_id = id,
        lang = lang,
        last_edit_time = last_edit_time,
        logo = logo,
        name = name
    )

    private fun CityRaw.toEntity() = City(
        id = id,
        logo = logo,
        name = name,
        lang = lang,
        lastEditTime = last_edit_time
    )
}
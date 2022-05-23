package by.ssrlab.krokapp.mobile.shared.data.repos

import by.ssrlab.krokapp.mobile.shared.data.api.services.CitiesApiService
import by.ssrlab.krokapp.mobile.shared.data.mappers.CitiesApiMapper
import by.ssrlab.krokapp.mobile.shared.domain.entities.City
import by.ssrlab.krokapp.mobile.shared.domain.repos.CitiesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

/**
 * @author Alexander Nevertovich
 */
class CitiesRepositoryImpl(
    private val citiesApiService: CitiesApiService,
    private val citiesApiMapper: CitiesApiMapper
) : CitiesRepository {

    override fun getCities(): Flow<List<City>> {
        return flow {
            emit(citiesApiService.getCities())
        }.map { cities ->
            cities.map { citiesApiMapper(it) }
        }
    }
}
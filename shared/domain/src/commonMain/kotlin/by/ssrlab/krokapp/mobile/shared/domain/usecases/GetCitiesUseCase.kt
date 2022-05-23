package by.ssrlab.krokapp.mobile.shared.domain.usecases

import by.ssrlab.krokapp.mobile.shared.domain.entities.City
import by.ssrlab.krokapp.mobile.shared.domain.repos.CitiesRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Alexander Nevertovich
 */
class GetCitiesUseCase(
    private val citiesRepository: CitiesRepository
) {

    operator fun invoke(): Flow<List<City>> {
        return citiesRepository.getCities()
    }
}
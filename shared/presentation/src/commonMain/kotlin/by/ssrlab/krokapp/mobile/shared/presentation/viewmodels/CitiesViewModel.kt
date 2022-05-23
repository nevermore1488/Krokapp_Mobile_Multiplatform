package by.ssrlab.krokapp.mobile.shared.presentation.viewmodels

import by.ssrlab.krokapp.mobile.shared.domain.entities.City
import by.ssrlab.krokapp.mobile.shared.domain.usecases.GetCitiesUseCase
import kotlinx.coroutines.flow.Flow

/**
 * @author Alexander Nevertovich
 */
class CitiesViewModel(
    private val getCitiesUseCase: GetCitiesUseCase
) {

    fun  getCities(): Flow<List<City>> {
        return getCitiesUseCase.invoke()
    }
}
package by.ssrlab.krokapp.mobile.shared.presentation.viewmodels

import by.ssrlab.krokapp.mobile.shared.domain.entities.City
import by.ssrlab.krokapp.mobile.shared.domain.usecases.GetCitiesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

/**
 * @author Alexander Nevertovich
 */
class CitiesViewModel(
    private val getCitiesUseCase: GetCitiesUseCase
) : SharedViewModel() {

    val citiesState = MutableStateFlow<List<City>>(emptyList())

    init {
        viewModelScope.launch {
            getCitiesUseCase().collect {
                citiesState.value = it
            }
        }
    }
}
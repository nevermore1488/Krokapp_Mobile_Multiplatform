package by.ssrlab.krokapp.mobile.android.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import by.ssrlab.krokapp.mobile.android.di.CitiesComponent
import by.ssrlab.krokapp.mobile.shared.domain.entities.City
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text

/**
 * @author Alexander Nevertovich
 */
@Composable
fun CitiesScreen(
    citiesComponent: CitiesComponent = viewModel()
) {
    val cities = citiesComponent.vm.getCities().collectAsState(initial = emptyList()).value
    
    LazyColumn {
        items(cities) {
            CityItem(it)
        }
    }
}

@Composable
fun CityItem(
    city: City
) { 
    Text(text = city.name)
}
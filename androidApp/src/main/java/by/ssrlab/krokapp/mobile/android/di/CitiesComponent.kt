package by.ssrlab.krokapp.mobile.android.di

import androidx.lifecycle.ViewModel
import by.ssrlab.krokapp.mobile.shared.presentation.viewmodels.CitiesViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author Alexander Nevertovich
 */
@HiltViewModel
class CitiesComponent @Inject constructor(
    val vm: CitiesViewModel
): ViewModel() {
}
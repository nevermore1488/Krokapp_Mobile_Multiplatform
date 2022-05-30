package by.ssrlab.krokapp.mobile.shared.presentation.viewmodels

import kotlinx.coroutines.cancel

/**
 * @author Alexander Nevertovich
 */
abstract class SharedViewModel : BaseSharedViewModel() {

    fun clean() {
        viewModelScope.cancel()

        onCleaned()
    }

    open fun onCleaned() = Unit
}
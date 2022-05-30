package by.ssrlab.krokapp.mobile.shared.presentation.viewmodels

import kotlinx.coroutines.CoroutineScope

/**
 * @author Alexander Nevertovich
 */
expect abstract class BaseSharedViewModel() {
    protected val viewModelScope: CoroutineScope
}
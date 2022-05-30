package by.ssrlab.krokapp.mobile.shared.presentation.viewmodels

import kotlinx.coroutines.CoroutineScope

/**
 * @author Alexander Nevertovich
 */
actual abstract class BaseSharedViewModel {

    protected actual val viewModelScope: CoroutineScope
        get() = throw NotImplementedError("Implement me, ios side")
}
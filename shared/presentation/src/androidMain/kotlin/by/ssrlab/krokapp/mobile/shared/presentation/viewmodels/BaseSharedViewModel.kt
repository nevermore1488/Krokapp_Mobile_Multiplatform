package by.ssrlab.krokapp.mobile.shared.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

/**
 * @author Alexander Nevertovich
 */
actual abstract class BaseSharedViewModel : ViewModel() {

    protected actual val viewModelScope: CoroutineScope
        get() = (this as ViewModel).viewModelScope
}
package ir.alirezanazari.clubhome.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.alirezanazari.clubhome.util.LiveEvent
import ir.alirezanazari.domain.entity.base.ErrorEntity
import ir.alirezanazari.domain.entity.base.ResultEntity
import kotlinx.coroutines.launch

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

open class BaseViewModel: ViewModel() {

    private val _errorMessage = LiveEvent<ErrorEntity>()
    val errorMessage: LiveEvent<ErrorEntity>
        get() = _errorMessage


    private val _loading = LiveEvent<Boolean>()
    val loading: LiveEvent<Boolean>
        get() = _loading


    fun launchRequest(block: suspend () -> ResultEntity<Any>) =
        viewModelScope.launch {
            _loading.value = true
            val result = block()
            if (result is ResultEntity.Error) {
                _errorMessage.value = result.error
            }
            _loading.value = false
        }

}
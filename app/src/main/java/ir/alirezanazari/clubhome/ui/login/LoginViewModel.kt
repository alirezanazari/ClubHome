package ir.alirezanazari.clubhome.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ir.alirezanazari.clubhome.ui.base.BaseViewModel
import ir.alirezanazari.clubhome.util.updateOnSuccess
import ir.alirezanazari.domain.entity.register.StartPhoneNumberAuth
import ir.alirezanazari.domain.usecase.register.GetLoginUseCase
import javax.inject.Inject

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

class LoginViewModel @Inject constructor(
    private val loginUseCase: GetLoginUseCase
): BaseViewModel() {

    private val _loginResponse =  MutableLiveData<StartPhoneNumberAuth.Response>()
    val loginResponse : LiveData<StartPhoneNumberAuth.Response>
        get() = _loginResponse

    fun login(number: String) = launchRequest {
        loginUseCase.invoke(StartPhoneNumberAuth.Request(number))
            .updateOnSuccess(_loginResponse)
    }

}
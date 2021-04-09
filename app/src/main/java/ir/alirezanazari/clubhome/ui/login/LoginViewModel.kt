package ir.alirezanazari.clubhome.ui.login

import androidx.lifecycle.LiveData
import ir.alirezanazari.clubhome.ui.base.BaseViewModel
import ir.alirezanazari.clubhome.util.LiveEvent
import ir.alirezanazari.clubhome.util.updateOnSuccess
import ir.alirezanazari.data.util.SessionManager
import ir.alirezanazari.domain.entity.base.ResultEntity
import ir.alirezanazari.domain.entity.register.CompletePhoneNumberAuth
import ir.alirezanazari.domain.entity.register.StartPhoneNumberAuth
import ir.alirezanazari.domain.usecase.register.GetLoginUseCase
import ir.alirezanazari.domain.usecase.register.GetVerifyUseCase
import javax.inject.Inject

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

class LoginViewModel @Inject constructor(
    private val loginUseCase: GetLoginUseCase,
    private val verifyUseCase: GetVerifyUseCase,
    private val sessionManager: SessionManager
) : BaseViewModel() {

    var isLoggedIn = false

    private val _loginResponse = LiveEvent<StartPhoneNumberAuth.Response>()
    val loginResponse: LiveData<StartPhoneNumberAuth.Response>
        get() = _loginResponse

    fun login(number: String) = launchRequest {
        loginUseCase.invoke(StartPhoneNumberAuth.Request(number))
            .updateOnSuccess(_loginResponse)
            .also {
                if (it.isSuccessful()) isLoggedIn = true
            }
    }


    private val _verifyResponse = LiveEvent<CompletePhoneNumberAuth.Response>()
    val verifyResponse: LiveData<CompletePhoneNumberAuth.Response>
        get() = _verifyResponse

    fun verify(phoneNumber: String, code: String) = launchRequest {
        verifyUseCase.invoke(CompletePhoneNumberAuth.Request(phoneNumber, code))
            .updateOnSuccess(_verifyResponse)
            .also { result ->
                if (result.isSuccessful())
                    saveUserProfile((result as ResultEntity.Success).data)
            }
    }


    private fun saveUserProfile(response: CompletePhoneNumberAuth.Response) {
        sessionManager.apply {
            userToken = response.authToken
            userID = response.userProfile?.userId.toString()
            isWaitlisted = response.isWaitlisted
            write()
        }
    }
}
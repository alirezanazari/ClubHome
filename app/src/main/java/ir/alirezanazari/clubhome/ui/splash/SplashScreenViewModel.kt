package ir.alirezanazari.clubhome.ui.splash

import ir.alirezanazari.clubhome.ui.base.BaseViewModel
import ir.alirezanazari.data.util.SessionManager
import javax.inject.Inject

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

class SplashScreenViewModel @Inject constructor(
    private val sessionManager: SessionManager
) : BaseViewModel() {

    val isWaitListed: Boolean
        get() = sessionManager.isWaitlisted

    val isLoggedIn: Boolean
        get() = !sessionManager.userID.isNullOrEmpty()

    fun loadSessionManager() {
        sessionManager.load()
    }
}
package ir.alirezanazari.clubhome.ui.waiting

import ir.alirezanazari.clubhome.ui.base.BaseViewModel
import ir.alirezanazari.data.util.SessionManager
import javax.inject.Inject

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

class WaitingListViewModel @Inject constructor(
    private val sessionManager: SessionManager
) : BaseViewModel() {

    fun logout() {
        sessionManager.logout()
    }
}
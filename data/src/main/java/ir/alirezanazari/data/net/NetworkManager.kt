package ir.alirezanazari.data.net

import ir.alirezanazari.domain.entity.base.ResultEntity
import ir.alirezanazari.domain.entity.register.CompletePhoneNumberAuth
import ir.alirezanazari.domain.entity.register.StartPhoneNumberAuth

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

interface NetworkManager {

    suspend fun startPhoneNumberAuth(request: StartPhoneNumberAuth.Request): ResultEntity<StartPhoneNumberAuth.Response>

    suspend fun completePhoneNumberAuth(request: CompletePhoneNumberAuth.Request): ResultEntity<CompletePhoneNumberAuth.Response>
}
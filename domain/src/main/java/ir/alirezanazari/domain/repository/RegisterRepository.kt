package ir.alirezanazari.domain.repository

import ir.alirezanazari.domain.entity.base.ResultEntity
import ir.alirezanazari.domain.entity.register.CompletePhoneNumberAuth
import ir.alirezanazari.domain.entity.register.StartPhoneNumberAuth

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

interface RegisterRepository {

    suspend fun login(request: StartPhoneNumberAuth.Request): ResultEntity<StartPhoneNumberAuth.Response>

    suspend fun verify(request: CompletePhoneNumberAuth.Request): ResultEntity<CompletePhoneNumberAuth.Response>
}
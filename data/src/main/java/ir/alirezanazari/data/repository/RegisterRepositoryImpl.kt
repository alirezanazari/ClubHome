package ir.alirezanazari.data.repository

import ir.alirezanazari.data.net.NetworkManager
import ir.alirezanazari.domain.entity.base.ResultEntity
import ir.alirezanazari.domain.entity.register.CompletePhoneNumberAuth
import ir.alirezanazari.domain.entity.register.StartPhoneNumberAuth
import ir.alirezanazari.domain.repository.RegisterRepository

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

class RegisterRepositoryImpl(
    private val networkManager: NetworkManager
) : RegisterRepository {

    override suspend fun login(request: StartPhoneNumberAuth.Request): ResultEntity<StartPhoneNumberAuth.Response> {
        return networkManager.startPhoneNumberAuth(request)
    }

    override suspend fun verify(request: CompletePhoneNumberAuth.Request): ResultEntity<CompletePhoneNumberAuth.Response> {
        return networkManager.completePhoneNumberAuth(request)
    }
}
package ir.alirezanazari.domain.usecase.register

import ir.alirezanazari.domain.entity.base.ResultEntity
import ir.alirezanazari.domain.entity.register.StartPhoneNumberAuth
import ir.alirezanazari.domain.repository.RegisterRepository
import ir.alirezanazari.domain.usecase.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

class GetLoginUseCase(
    private val repository: RegisterRepository,
    dispatcher: CoroutineDispatcher
) : BaseUseCase<StartPhoneNumberAuth.Request, ResultEntity<StartPhoneNumberAuth.Response>>(
    dispatcher
) {
    override suspend fun execute(parameters: StartPhoneNumberAuth.Request): ResultEntity<StartPhoneNumberAuth.Response> {
        return repository.login(parameters)
    }

}
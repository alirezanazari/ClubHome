package ir.alirezanazari.domain.usecase.register

import ir.alirezanazari.domain.entity.base.ResultEntity
import ir.alirezanazari.domain.entity.register.CompletePhoneNumberAuth
import ir.alirezanazari.domain.repository.RegisterRepository
import ir.alirezanazari.domain.usecase.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

class GetVerifyUseCase(
    private val repository: RegisterRepository,
    dispatcher: CoroutineDispatcher
) : BaseUseCase<CompletePhoneNumberAuth.Request, ResultEntity<CompletePhoneNumberAuth.Response>>(
    dispatcher
) {
    override suspend fun execute(parameters: CompletePhoneNumberAuth.Request): ResultEntity<CompletePhoneNumberAuth.Response> {
        return repository.verify(parameters)
    }

}
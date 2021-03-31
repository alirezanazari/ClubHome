package ir.alirezanazari.data.net

import ir.alirezanazari.domain.entity.base.ResultEntity
import ir.alirezanazari.domain.entity.register.CompletePhoneNumberAuth
import ir.alirezanazari.domain.entity.register.StartPhoneNumberAuth

class NetworkManagerImpl(
    private val api: RestApi,
    private val errorHandler: ErrorHandler
) : NetworkManager {

    override suspend fun startPhoneNumberAuth(request: StartPhoneNumberAuth.Request): ResultEntity<StartPhoneNumberAuth.Response> =
        doRequest {
            api.startPhoneNumberAuth(request)
        }

    override suspend fun completePhoneNumberAuth(request: CompletePhoneNumberAuth.Request): ResultEntity<CompletePhoneNumberAuth.Response> =
        doRequest {
            api.completePhoneNumberAuth(request)
        }

    private suspend fun <T> doRequest(apiCall: suspend () -> T): ResultEntity<T> {
        return try {
            ResultEntity.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            ResultEntity.Error(errorHandler.getError(throwable))
        }
    }

}
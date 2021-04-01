package ir.alirezanazari.data.net

import ir.alirezanazari.domain.entity.register.CompletePhoneNumberAuth
import ir.alirezanazari.domain.entity.register.StartPhoneNumberAuth
import retrofit2.http.Body
import retrofit2.http.POST

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

interface RestApi {

    @POST("start_phone_number_auth")
    suspend fun startPhoneNumberAuth(@Body request: StartPhoneNumberAuth.Request): StartPhoneNumberAuth.Response

    @POST("complete_phone_number_auth")
    suspend fun completePhoneNumberAuth(@Body request: CompletePhoneNumberAuth.Request): CompletePhoneNumberAuth.Response

}
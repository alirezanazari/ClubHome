package ir.alirezanazari.domain.entity.register

import ir.alirezanazari.domain.entity.UserProfile

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

sealed class CompletePhoneNumberAuth {

    data class Request(
        val phoneNumber: String,
        val verificationCode: String
    ) : CompletePhoneNumberAuth()

    data class Response(
        val authToken: String? = null,
        val accessToken: String? = null,
        val refreshToken: String? = null,
        val isWaitlisted: Boolean = false,
        val userProfile: UserProfile? = null
    ) : CompletePhoneNumberAuth()
}

package ir.alirezanazari.domain.entity.register

import ir.alirezanazari.domain.entity.base.BaseResponse

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

class StartPhoneNumberAuth {

    data class Request(
        val phoneNumber: String = ""
    )

    class Response : BaseResponse()
}

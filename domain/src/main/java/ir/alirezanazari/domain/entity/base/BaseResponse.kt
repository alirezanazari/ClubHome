package ir.alirezanazari.domain.entity.base

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

open class BaseResponse(
    val success: Boolean = false,
    val error_message: String? = null
)

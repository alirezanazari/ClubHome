package ir.alirezanazari.domain.entity.base

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

sealed class ErrorEntity(var message: String, val code: Int) {

    object Network : ErrorEntity("No Network Access", -1)

    data class ApiError(val data: String, val errorCode: Int) : ErrorEntity(data, errorCode)

    data class Generic(val data: String) : ErrorEntity(data, -1)

    data class Unknown(val data: String) : ErrorEntity(data, -1)

}
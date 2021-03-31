package ir.alirezanazari.domain.entity.base

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

data class ErrorResponse(
    val status: Int = 0,
    val message: String = ""
)

package ir.alirezanazari.data.net

import ir.alirezanazari.domain.entity.base.ErrorEntity

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

interface ErrorHandler {
    fun getError(throwable: Throwable): ErrorEntity
}
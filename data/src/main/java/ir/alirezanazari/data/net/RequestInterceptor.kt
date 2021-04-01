package ir.alirezanazari.data.net

import android.content.Context
import android.os.LocaleList
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

class RequestInterceptor constructor(
    private val context: Context
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val locales = getLocales()
        val newRequest = chain.request().newBuilder()
            .addHeader("CH-Languages", locales.toLanguageTags())
            .addHeader("CH-Locale", locales.get(0).toLanguageTag().replace('-', '_'))
            .addHeader("Accept", "application/json")
            .addHeader("CH-AppBuild", API_BUILD_ID)
            .addHeader("CH-AppVersion", API_BUILD_VERSION)
            .addHeader("User-Agent", API_UA)
            .addHeader("CH-DeviceId", UUID.randomUUID().toString().toUpperCase(Locale.ENGLISH))
            .build()
        return chain.proceed(newRequest)
    }

    private fun getLocales(): LocaleList {
        return context.resources.configuration.locales
    }

    companion object {
        const val API_BUILD_ID = "304"
        const val API_BUILD_VERSION = "0.1.28"
        const val API_UA = "clubhouse/$API_BUILD_ID (iPhone; iOS 13.5.1; Scale/3.00)"
    }
}
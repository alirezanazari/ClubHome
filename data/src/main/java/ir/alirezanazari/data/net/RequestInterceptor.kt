package ir.alirezanazari.data.net

import android.content.Context
import android.os.LocaleList
import ir.alirezanazari.data.util.SessionManager
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

class RequestInterceptor constructor(
    private val context: Context,
    private val sessionManager: SessionManager
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
            .addHeader("CH-DeviceId", sessionManager.deviceID.orEmpty())
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
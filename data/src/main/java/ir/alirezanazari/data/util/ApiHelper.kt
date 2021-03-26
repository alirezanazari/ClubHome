package ir.alirezanazari.data.util

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

class ApiHelper constructor(
    private val okHttpClient: OkHttpClient,
    private val baseUrl: String
) {

    lateinit var restApi : RestApi

    init {
        initializeRetrofit()
    }

    private fun initializeRetrofit() {
        restApi = Retrofit.Builder().baseUrl(baseUrl)
            .client(okHttpClient)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RestApi::class.java)
    }
}
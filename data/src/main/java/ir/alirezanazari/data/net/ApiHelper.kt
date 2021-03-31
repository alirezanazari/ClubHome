package ir.alirezanazari.data.net

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

class ApiHelper {
    companion object {
        operator fun invoke(okHttpClient: OkHttpClient, baseUrl: String): RestApi {
            return Retrofit.Builder().baseUrl(baseUrl)
                .client(okHttpClient)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RestApi::class.java)
        }
    }
}
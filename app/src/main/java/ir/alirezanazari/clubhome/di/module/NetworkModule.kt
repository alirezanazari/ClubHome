package ir.alirezanazari.clubhome.di.module

import android.content.Context
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import ir.alirezanazari.clubhome.BuildConfig
import ir.alirezanazari.clubhome.Constants
import ir.alirezanazari.data.net.*
import ir.alirezanazari.data.util.SessionManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

@Module
object NetworkModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
            .disableHtmlEscaping()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
    }

    @Provides
    @Singleton
    fun provideRequestInterceptor(context: Context, sessionManager: SessionManager): RequestInterceptor {
        return RequestInterceptor(context, sessionManager)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: RequestInterceptor): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(logging)
            .readTimeout(Constants.REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(Constants.REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(Constants.REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiHelper(client: OkHttpClient, gson: Gson): RestApi {
        return ApiHelper(client, gson, Constants.BASE_URL)
    }

    @Provides
    @Singleton
    fun provideErrorHandler(): ErrorHandler {
        return ErrorHandlerImpl()
    }

    @Provides
    @Singleton
    fun provideNetworkManager(restApi: RestApi, errorHandler: ErrorHandler): NetworkManager {
        return NetworkManagerImpl(restApi, errorHandler)
    }
}
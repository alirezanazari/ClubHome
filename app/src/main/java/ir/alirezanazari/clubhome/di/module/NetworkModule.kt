package ir.alirezanazari.clubhome.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import ir.alirezanazari.clubhome.BuildConfig
import ir.alirezanazari.clubhome.Constants
import ir.alirezanazari.data.net.*
import ir.alirezanazari.data.repository.RegisterRepositoryImpl
import ir.alirezanazari.domain.repository.RegisterRepository
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
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .readTimeout(Constants.REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(Constants.REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(Constants.REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiHelper(client: OkHttpClient): RestApi {
        return ApiHelper(client, Constants.BASE_URL)
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

    @Provides
    fun provideRegisterRepository(networkManager: NetworkManager): RegisterRepository {
        return RegisterRepositoryImpl(networkManager)
    }
}
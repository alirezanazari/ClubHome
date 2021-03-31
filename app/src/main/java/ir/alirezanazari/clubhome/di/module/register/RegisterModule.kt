package ir.alirezanazari.clubhome.di.module.register

import dagger.Module
import dagger.Provides
import ir.alirezanazari.data.net.NetworkManager
import ir.alirezanazari.data.repository.RegisterRepositoryImpl
import ir.alirezanazari.domain.repository.RegisterRepository
import ir.alirezanazari.domain.usecase.register.GetLoginUseCase
import ir.alirezanazari.domain.usecase.register.GetVerifyUseCase
import kotlinx.coroutines.Dispatchers

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

@Module
class RegisterModule {

    @Provides
    fun provideRegisterRepository(networkManager: NetworkManager): RegisterRepository {
        return RegisterRepositoryImpl(networkManager)
    }

    @Provides
    fun provideLoginUseCase(repository: RegisterRepository): GetLoginUseCase {
        return GetLoginUseCase(repository, Dispatchers.IO)
    }

    @Provides
    fun provideVerifyUseCase(repository: RegisterRepository): GetVerifyUseCase {
        return GetVerifyUseCase(repository, Dispatchers.IO)
    }
}
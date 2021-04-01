package ir.alirezanazari.clubhome.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import ir.alirezanazari.data.util.SessionManager
import javax.inject.Singleton

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

@Module
object AppModule {

    @Provides
    @Singleton
    fun provideSessionManager(context: Context): SessionManager{
        return SessionManager(context)
    }

}
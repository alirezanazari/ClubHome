package ir.alirezanazari.clubhome.di.component

import dagger.Subcomponent
import ir.alirezanazari.clubhome.di.module.MainViewModelModule
import ir.alirezanazari.clubhome.di.scope.MainScope
import ir.alirezanazari.clubhome.ui.main.MainFragment
import ir.alirezanazari.clubhome.ui.profile.ProfileFragment
import ir.alirezanazari.clubhome.ui.splash.SplashScreenFragment

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

@MainScope
@Subcomponent(modules = [MainViewModelModule::class])
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

    fun inject(fragment: SplashScreenFragment)
    fun inject(fragment: MainFragment)
    fun inject(fragment: ProfileFragment)
}
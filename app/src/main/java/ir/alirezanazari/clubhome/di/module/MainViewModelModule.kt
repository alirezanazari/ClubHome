package ir.alirezanazari.clubhome.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ir.alirezanazari.clubhome.di.annotations.ViewModelKey
import ir.alirezanazari.clubhome.ui.splash.SplashScreenViewModel

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashScreenViewModel::class)
    abstract fun bindSplashScreenViewModel(viewModel: SplashScreenViewModel): ViewModel
}
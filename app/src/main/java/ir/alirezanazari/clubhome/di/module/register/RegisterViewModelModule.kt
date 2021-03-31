package ir.alirezanazari.clubhome.di.module.register

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ir.alirezanazari.clubhome.di.annotations.ViewModelKey
import ir.alirezanazari.clubhome.ui.login.LoginViewModel
import ir.alirezanazari.clubhome.ui.register.RegisterViewModel
import ir.alirezanazari.clubhome.ui.waiting.WaitingListViewModel

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

@Module
abstract class RegisterViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(WaitingListViewModel::class)
    abstract fun bindWaitingListViewModel(viewModel: WaitingListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel::class)
    abstract fun bindRegisterViewModel(viewModel: RegisterViewModel): ViewModel
}
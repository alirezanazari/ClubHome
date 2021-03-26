package ir.alirezanazari.clubhome.di.component

import dagger.Subcomponent
import ir.alirezanazari.clubhome.di.module.RegisterViewModelModule
import ir.alirezanazari.clubhome.di.scope.RegisterScope
import ir.alirezanazari.clubhome.ui.login.LoginFragment
import ir.alirezanazari.clubhome.ui.waiting.WaitingListFragment

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

@RegisterScope
@Subcomponent(modules = [RegisterViewModelModule::class])
interface RegistrationComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): RegistrationComponent
    }

    fun inject(fragment: WaitingListFragment)
    fun inject(fragment: LoginFragment)

}
package ir.alirezanazari.clubhome.di.component

import dagger.Subcomponent
import ir.alirezanazari.clubhome.di.scope.RegisterScope

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

@RegisterScope
@Subcomponent(modules = [])
interface RegistrationComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): RegistrationComponent
    }

}
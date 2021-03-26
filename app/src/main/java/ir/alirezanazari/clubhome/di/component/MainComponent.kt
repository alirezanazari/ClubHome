package ir.alirezanazari.clubhome.di.component

import dagger.Subcomponent
import ir.alirezanazari.clubhome.di.scope.MainScope

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

@MainScope
@Subcomponent(modules = [])
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

}
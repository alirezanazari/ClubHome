package ir.alirezanazari.clubhome.di.component

import dagger.Subcomponent
import ir.alirezanazari.clubhome.di.scope.ChannelScope

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

@ChannelScope
@Subcomponent(modules = [])
interface ChannelComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ChannelComponent
    }

}
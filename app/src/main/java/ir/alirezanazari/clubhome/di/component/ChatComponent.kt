package ir.alirezanazari.clubhome.di.component

import dagger.Subcomponent
import ir.alirezanazari.clubhome.di.module.ChatViewModelModule
import ir.alirezanazari.clubhome.di.scope.ChannelScope
import ir.alirezanazari.clubhome.ui.chat.ChatFragment
import ir.alirezanazari.clubhome.ui.followers.FollowersFragment
import ir.alirezanazari.clubhome.ui.followings.FollowingsFragment

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

@ChannelScope
@Subcomponent(modules = [ChatViewModelModule::class])
interface ChatComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ChatComponent
    }

    fun inject(fragment: ChatFragment)
    fun inject(fragment: FollowersFragment)
    fun inject(fragment: FollowingsFragment)
}
package ir.alirezanazari.clubhome.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ir.alirezanazari.clubhome.di.annotations.ViewModelKey
import ir.alirezanazari.clubhome.ui.chat.ChatViewModel
import ir.alirezanazari.clubhome.ui.followers.FollowersViewModel
import ir.alirezanazari.clubhome.ui.followings.FollowingViewModel

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

@Module
abstract class ChatViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ChatViewModel::class)
    abstract fun bindChatViewModel(viewModel: ChatViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FollowersViewModel::class)
    abstract fun bindFollowersViewModel(viewModel: FollowersViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FollowingViewModel::class)
    abstract fun bindFollowingViewModel(viewModel: FollowingViewModel): ViewModel
}
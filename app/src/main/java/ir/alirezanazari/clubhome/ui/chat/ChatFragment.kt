package ir.alirezanazari.clubhome.ui.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import ir.alirezanazari.clubhome.R
import ir.alirezanazari.clubhome.databinding.FragmentChatBinding
import ir.alirezanazari.clubhome.ui.base.BaseFragment
import ir.alirezanazari.clubhome.util.ViewModelFactory
import javax.inject.Inject

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

class ChatFragment :
    BaseFragment<ChatViewModel, FragmentChatBinding>(R.layout.fragment_chat) {

    @Inject
    override lateinit var viewModelFactory: ViewModelFactory

    override fun initViewModel(): Lazy<ChatViewModel> = viewModels()

    override fun inject() {
        getAppComponent().chatComponent().create().inject(this)
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentChatBinding {
        return FragmentChatBinding.inflate(inflater, container, false)
    }

}
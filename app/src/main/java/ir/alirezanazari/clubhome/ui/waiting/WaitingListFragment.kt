package ir.alirezanazari.clubhome.ui.waiting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import ir.alirezanazari.clubhome.R
import ir.alirezanazari.clubhome.databinding.FragmentWaitingListBinding
import ir.alirezanazari.clubhome.ui.base.BaseFragment
import ir.alirezanazari.clubhome.util.ViewModelFactory
import javax.inject.Inject

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

class WaitingListFragment :
    BaseFragment<WaitingListViewModel, FragmentWaitingListBinding>(R.layout.fragment_waiting_list) {

    @Inject
    override lateinit var viewModelFactory: ViewModelFactory

    override fun initViewModel(): Lazy<WaitingListViewModel> = viewModels()

    override fun inject() {
        getAppComponent().registrationComponent().create().inject(this)
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentWaitingListBinding {
        return FragmentWaitingListBinding.inflate(inflater, container, false)
    }

}
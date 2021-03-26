package ir.alirezanazari.clubhome.ui.followings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import ir.alirezanazari.clubhome.R
import ir.alirezanazari.clubhome.databinding.FragmentListBinding
import ir.alirezanazari.clubhome.ui.base.BaseFragment
import ir.alirezanazari.clubhome.util.ViewModelFactory
import javax.inject.Inject

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

class FollowingsFragment :
    BaseFragment<FollowingViewModel, FragmentListBinding>(R.layout.fragment_list) {

    @Inject
    override lateinit var viewModelFactory: ViewModelFactory

    override fun initViewModel(): Lazy<FollowingViewModel> = viewModels()

    override fun inject() {
        getAppComponent().chatComponent().create().inject(this)
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentListBinding {
        return FragmentListBinding.inflate(inflater, container, false)
    }

}
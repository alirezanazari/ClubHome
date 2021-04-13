package ir.alirezanazari.clubhome.ui.waiting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.buildSpannedString
import androidx.core.text.color
import androidx.core.text.underline
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import ir.alirezanazari.clubhome.R
import ir.alirezanazari.clubhome.databinding.FragmentWaitingListBinding
import ir.alirezanazari.clubhome.ui.base.BaseFragment
import ir.alirezanazari.clubhome.util.ViewModelFactory
import ir.alirezanazari.clubhome.util.getColor
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

    override fun bindViews(savedInstanceState: Bundle?) {
        binding.logoutButton.apply {
            text = buildSpannedString {
                color(getColor(R.color.primary)) {
                    underline { append(getString(R.string.logout)) }
                }
            }
            setOnClickListener {
                viewModel.logout()
                findNavController().popBackStack()
            }
        }
    }
}
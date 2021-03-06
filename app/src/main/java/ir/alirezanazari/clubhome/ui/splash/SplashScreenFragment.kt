package ir.alirezanazari.clubhome.ui.splash

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import ir.alirezanazari.clubhome.R
import ir.alirezanazari.clubhome.databinding.FragmentSplashScreenBinding
import ir.alirezanazari.clubhome.ui.base.BaseFragment
import ir.alirezanazari.clubhome.util.ViewModelFactory
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

class SplashScreenFragment :
    BaseFragment<SplashScreenViewModel, FragmentSplashScreenBinding>(R.layout.fragment_splash_screen) {

    @Inject
    override lateinit var viewModelFactory: ViewModelFactory

    override fun initViewModel(): Lazy<SplashScreenViewModel> = viewModels()

    override fun inject() {
        getAppComponent().mainComponent().create().inject(this)
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSplashScreenBinding {
        return FragmentSplashScreenBinding.inflate(inflater, container, false)
    }

    override fun onFragmentStarted() {
        viewModel.loadSessionManager()
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            delay(1000)
            findNavController().navigate(getNextStep())
        }
    }

    private fun getNextStep(): NavDirections {
        return if (viewModel.isLoggedIn) {
            if (viewModel.isWaitListed)
                SplashScreenFragmentDirections.actionToNavWaitlisted()
            else
                SplashScreenFragmentDirections.actionSplashScreenToMain()
        } else {
            SplashScreenFragmentDirections.actionSplashScreenToRegister()
        }
    }
}
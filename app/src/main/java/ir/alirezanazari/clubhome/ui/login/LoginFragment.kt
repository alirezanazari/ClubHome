package ir.alirezanazari.clubhome.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import ir.alirezanazari.clubhome.R
import ir.alirezanazari.clubhome.databinding.FragmentLoginBinding
import ir.alirezanazari.clubhome.ui.base.BaseFragment
import ir.alirezanazari.clubhome.util.ViewModelFactory
import ir.alirezanazari.clubhome.util.onBackPressed
import ir.alirezanazari.clubhome.util.showKeyboard
import javax.inject.Inject

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

class LoginFragment :
    BaseFragment<LoginViewModel, FragmentLoginBinding>(R.layout.fragment_login) {

    @Inject
    override lateinit var viewModelFactory: ViewModelFactory

    override fun initViewModel(): Lazy<LoginViewModel> = viewModels()

    override fun inject() {
        getAppComponent().registrationComponent().create().inject(this)
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(inflater, container, false)
    }

    override fun bindViews(savedInstanceState: Bundle?) {
        super.bindViews(savedInstanceState)
        resizeWindowOnKeyboard(true)
        binding.apply {
            phoneEditText.showKeyboard()
            countryPickerView.registerPhoneNumberTextView(phoneEditText)
        }
    }

    override fun doLogics() {
        onBackPressed {
            requireActivity().finish()
        }
    }
}
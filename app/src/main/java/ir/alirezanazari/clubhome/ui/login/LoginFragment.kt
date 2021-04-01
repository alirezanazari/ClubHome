package ir.alirezanazari.clubhome.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import ir.alirezanazari.clubhome.R
import ir.alirezanazari.clubhome.databinding.FragmentLoginBinding
import ir.alirezanazari.clubhome.ui.base.BaseFragment
import ir.alirezanazari.clubhome.util.*
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
            countryPickerView.registerPhoneNumberTextView(phoneEditText)
            phoneEditText.apply {
                showKeyboard()
                doAfterTextChanged { text ->
                    actionButton.isEnabled = text.toString().isNotEmpty()
                }
            }
            actionButton.setOnClickListener {
                val number = phoneEditText.text.toString()
                if (number.isPhoneNumber()) {
                    viewModel.login(countryPickerView.number)
                }
            }
        }
    }

    override fun doLogics() {
        onBackPressed {
            requireActivity().finish()
        }
        observeError()
        observerLoading()
        observeLogin()
    }

    private fun observeLogin() {
        viewModel.loginResponse.observe(viewLifecycleOwner) { response ->
            log(response.toString())
        }
    }

    private fun observeError(){
        viewModel.errorMessage.observe(viewLifecycleOwner) {
            toast(it.message)
        }
    }

    private fun observerLoading() {
        viewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            binding.actionButton.text = getString(if (isLoading) R.string.loading else R.string.next)
        }
    }
}
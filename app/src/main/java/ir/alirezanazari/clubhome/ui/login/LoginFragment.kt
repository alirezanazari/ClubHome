package ir.alirezanazari.clubhome.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ir.alirezanazari.clubhome.R
import ir.alirezanazari.clubhome.databinding.FragmentLoginBinding
import ir.alirezanazari.clubhome.ui.base.BaseFragment
import ir.alirezanazari.clubhome.util.*
import ir.alirezanazari.domain.entity.register.CompletePhoneNumberAuth
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
                onActionButtonClicked()
            }
        }
    }

    override fun doLogics() {
        observeError()
        observerLoading()
        observeLogin()
        observeVerification()
        onBackPressed {
            requireActivity().finish()
        }
    }

    private fun observeLogin() {
        viewModel.loginResponse.observe(viewLifecycleOwner) {
            binding.apply {
                codeEditText.apply {
                    visible()
                    requestFocus()
                }
                actionButton.setText(R.string.verify_code)
            }
        }
    }

    private fun observeVerification() {
        viewModel.verifyResponse.observe(viewLifecycleOwner) { response ->
            navigateToNextStep(response)
        }
    }

    private fun observeError() {
        viewModel.errorMessage.observe(viewLifecycleOwner) {
            toast(it.message)
            binding.actionButton.setText(getActionButtonText())
        }
    }

    private fun observerLoading() {
        viewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            binding.actionButton.setText(
                if (isLoading) R.string.loading else getActionButtonText()
            )
        }
    }

    private fun navigateToNextStep(response: CompletePhoneNumberAuth.Response) {
        findNavController().navigate(
            when {
                response.isWaitlisted ->
                    LoginFragmentDirections.actionLoginToWaitingList()

                response.userProfile?.username.isNullOrEmpty() ->
                    LoginFragmentDirections.actionLoginToRegister()

                else ->
                    LoginFragmentDirections.actionLoginToMain()
            }
        )
    }

    private fun onActionButtonClicked() {
        val number = binding.countryPickerView.number
        if (!viewModel.isLoggedIn) {
            login(number)
        } else {
            verify(number)
        }
    }

    private fun login(number: String) {
        if (number.isPhoneNumber()) {
            viewModel.login(number)
        } else {
            toast(getString(R.string.phone_number_is_wrong))
        }
    }

    private fun verify(number: String) {
        val verifyCode = binding.codeEditText.text.toString()
        viewModel.verify(number, verifyCode)
    }

    private fun getActionButtonText() =
        if (viewModel.isLoggedIn) R.string.verify_code else R.string.next
}
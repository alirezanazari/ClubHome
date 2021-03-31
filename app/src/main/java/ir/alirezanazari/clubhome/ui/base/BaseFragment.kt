package ir.alirezanazari.clubhome.ui.base

import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import ir.alirezanazari.clubhome.G
import ir.alirezanazari.clubhome.R
import ir.alirezanazari.clubhome.di.component.AppComponent
import ir.alirezanazari.clubhome.util.ViewModelFactory
import kotlin.properties.ReadOnlyProperty

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

abstract class BaseFragment<V : BaseViewModel, B : ViewBinding>(resId: Int) :
    BaseViewBindingFragment<B>(resId) {

    private fun viewModelDelegate(): ReadOnlyProperty<BaseFragment<V, B>, V> =
        ReadOnlyProperty { _, _ -> initViewModel()?.value!! }

    val viewModel: V by viewModelDelegate()

    abstract var viewModelFactory: ViewModelFactory
    abstract fun initViewModel(): Lazy<V>?
    abstract fun inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        onFragmentStarted()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(ResourcesCompat.getColor(resources, R.color.background, null))
        bindViews(savedInstanceState)
        doLogics()
    }

    override fun getDefaultViewModelProviderFactory(): ViewModelProvider.Factory =
        viewModelFactory.create(this, arguments)

    fun getAppComponent(): AppComponent {
        return (requireActivity().application as G).appComponent
    }

    /**
     * this method is for doing operations once when fragment created
     */
    open fun onFragmentStarted() {}
    open fun bindViews(savedInstanceState: Bundle?) {}
    open fun doLogics() {}
}
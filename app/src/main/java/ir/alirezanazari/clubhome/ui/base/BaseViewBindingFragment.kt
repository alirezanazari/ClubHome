package ir.alirezanazari.clubhome.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

abstract class BaseViewBindingFragment<B : ViewBinding>(resId: Int) : Fragment(resId) {

    // This property is only valid between onCreateView and onDestroyView.
    val binding get() = _binding!!
    private var _binding: B? = null

    abstract fun initBinding(inflater: LayoutInflater, container: ViewGroup?): B

    @Suppress("UNCHECKED_CAST")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = initBinding(inflater, container)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
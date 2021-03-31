package ir.alirezanazari.clubhome.util

import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.


/**
 * Used for adding a callback to activity onBackPressed
 */
fun Fragment.onBackPressed(callback: () -> Unit) {
    requireActivity().onBackPressedDispatcher.addCallback(
        viewLifecycleOwner,
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                callback.invoke()
            }
        })
}

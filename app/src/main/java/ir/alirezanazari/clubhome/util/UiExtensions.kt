package ir.alirezanazari.clubhome.util

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
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

fun View.showKeyboard() {
    if (this is EditText) {
        this.requestFocus()
    }
    val imm = this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(
        this,
        InputMethodManager.SHOW_IMPLICIT
    )
}

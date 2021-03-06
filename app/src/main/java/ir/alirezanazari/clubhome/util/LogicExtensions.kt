package ir.alirezanazari.clubhome.util

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import ir.alirezanazari.domain.entity.base.ResultEntity
import kotlin.math.roundToInt

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.


/**
 * Updates value of [liveData] if [Result] is of type [Success]
 */
inline fun <reified T> ResultEntity<T>.updateOnSuccess(liveData: MutableLiveData<T>): ResultEntity<T> {
    if (this is ResultEntity.Success) {
        liveData.value = data
    }
    return this
}

fun String.isPhoneNumber(): Boolean {
    return this.length >= 11
}

fun Any.log(message: String) {
    Log.d(this.javaClass.simpleName, message)
}

fun Fragment.toast(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun Context.toDp(dp: Float): Float {
    return (dp * resources.displayMetrics.density).roundToInt().toFloat()
}
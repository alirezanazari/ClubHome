package ir.alirezanazari.clubhome.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.alirezanazari.clubhome.R

class MainActivity : AppCompatActivity() {

    var originalSoftInputMode: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        storeInputMode()
    }

    private fun storeInputMode() {
        originalSoftInputMode = window?.attributes?.softInputMode
    }

}
package ir.alirezanazari.clubhome

import android.app.Application
import ir.alirezanazari.clubhome.di.component.AppComponent
import ir.alirezanazari.clubhome.di.component.DaggerAppComponent

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

class G : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }

}
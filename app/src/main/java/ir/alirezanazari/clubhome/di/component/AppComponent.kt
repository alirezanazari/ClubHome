package ir.alirezanazari.clubhome.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ir.alirezanazari.clubhome.di.module.NetworkModule
import ir.alirezanazari.clubhome.di.module.ViewModelModule
import javax.inject.Singleton

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun registrationComponent(): RegistrationComponent.Factory

    fun chatComponent(): ChatComponent.Factory

    fun mainComponent(): MainComponent.Factory
}
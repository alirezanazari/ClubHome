package ir.alirezanazari.clubhome.di.module

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.multibindings.Multibinds
import ir.alirezanazari.clubhome.util.AssistedSavedStateViewModelFactory

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

@Module
abstract class ViewModelModule {

    @Multibinds
    abstract fun viewModels(): Map<Class<out ViewModel>, @JvmSuppressWildcards ViewModel>

    @Multibinds
    abstract fun assistedViewModels(): Map<Class<out ViewModel>, @JvmSuppressWildcards AssistedSavedStateViewModelFactory<out ViewModel>>

}
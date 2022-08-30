package com.mirkamol.multimodulapp.di
import com.mirkamol.multimodulapp.di.module.ApplicationModule
import com.mirkamol.multimodulapp.di.module.DataModule
import com.mirkamol.multimodulapp.di.module.ViewModelModule
import com.mirkamol.multimodulapp.App
import com.mirkamol.multimodulapp.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, DataModule::class, ViewModelModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App):AppComponent
    }

    fun inject(app: App)
    fun inject(mainActivity: MainActivity)
}
package ru.maxdexter.mywallpaper

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.maxdexter.mywallpaper.di.modules.networkModule
import ru.maxdexter.mywallpaper.di.modules.repositoryModule
import ru.maxdexter.mywallpaper.di.modules.useCaseModule
import ru.maxdexter.mywallpaper.di.modules.viewModelModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf( networkModule, repositoryModule, useCaseModule, viewModelModule))
        }

    }
}
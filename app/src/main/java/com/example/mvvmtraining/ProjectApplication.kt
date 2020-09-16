package com.example.mvvmtraining

import android.app.Application
import com.example.mvvmtraining.di.module.netWorkModule
import com.example.mvvmtraining.di.module.repositoryModule
import com.example.mvvmtraining.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ProjectApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ProjectApplication)
            modules(arrayListOf(netWorkModule, repositoryModule, viewModelModule))
            androidLogger()
        }
    }
}
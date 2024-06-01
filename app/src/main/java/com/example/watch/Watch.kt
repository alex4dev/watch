package com.example.watch

import android.app.Application
import com.example.watch.core.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Watch : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@Watch)
            modules(appModule)
        }
    }

}

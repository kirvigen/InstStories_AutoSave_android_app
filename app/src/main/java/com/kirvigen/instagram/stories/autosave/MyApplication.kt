package com.kirvigen.instagram.stories.autosave

import android.app.Application
import com.kirvigen.instagram.stories.autosave.activity.ViewModuleCreater
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MyApplication)
            modules(
                MainModuleCreater.create(),
                ViewModuleCreater.create()
            )
        }
    }

}
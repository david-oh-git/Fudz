package io.davidosemwota.fudz

import android.app.Application
import io.davidosemwota.fudz.storage.di.appModule
import io.davidosemwota.fudz.storage.di.storageModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class FudzApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initTimber()
        initKoin()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@FudzApp)
            modules(appModule, storageModule)
        }
    }
}
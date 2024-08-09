package dev.agustacandi.learn.suitmedia_1.base

import android.app.Application
import dev.agustacandi.learn.suitmedia_1.utils.ConstVal
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

// BaseApplication class to initialize Koin
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@BaseApplication)
            modules(
                ConstVal.koinModules
            )
        }
    }

}
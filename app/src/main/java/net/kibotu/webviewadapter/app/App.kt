package net.kibotu.webviewadapter.app

import androidx.multidex.MultiDexApplication
import net.kibotu.logger.Logger


/**
 * Created by [Jan Rabe](https://about.me/janrabe).
 */
class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        Logger.with(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        Logger.onTerminate()
    }
}
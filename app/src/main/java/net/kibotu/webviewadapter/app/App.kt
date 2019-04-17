package net.kibotu.webviewadapter.app

import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication


/**
 * Created by [Jan Rabe](https://about.me/janrabe).
 */
class App : MultiDexApplication() {

    init {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }
}
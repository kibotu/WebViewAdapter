/**
 * Created by [Jan Rabe](https://about.me/janrabe).
 */

@file:JvmName("DebugExtensions")

package net.kibotu.webviewadapter

import android.util.Log

internal val debug = true

internal fun Any.log(message: String?) {
    if (debug)
        Log.d(this::class.java.simpleName, "$message")
}

internal fun Exception.log(message: String?) {
    if (debug)
        Log.d(this::class.java.simpleName, "$message")
}
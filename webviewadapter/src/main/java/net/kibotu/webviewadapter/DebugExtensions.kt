/**
 * Created by [Jan Rabe](https://about.me/janrabe).
 */

@file:JvmName("DebugExtensions")

package net.kibotu.webviewadapter

import android.content.Context
import android.util.Log

internal val debug = BuildConfig.DEBUG

internal fun Any.log(message: (() -> String?)?) {
    if (debug)
        Log.d(this::class.java.simpleName, "${message?.invoke()}")
}

internal fun Int.resName(context: Context) = context.resources.getResourceEntryName(this)

internal fun Tab.resNameString(context: Context) =
    "Tab(url='$url', label=${label.resName(context)}, icon=${icon.resName(context)}, inactiveColor=${inactiveColor.resName(context)}, activeColor=${activeColor.resName(context)})"

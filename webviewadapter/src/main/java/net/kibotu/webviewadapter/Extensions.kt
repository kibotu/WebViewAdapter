@file:JvmName("Extensions")

package net.kibotu.webviewadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import com.google.android.material.tabs.TabLayout


fun TabLayout.addTab(@StringRes title: Int, @DrawableRes icon: Int, @LayoutRes customView: Int) {
    val tab = LayoutInflater.from(context).inflate(customView, this as ViewGroup, false) as TextView
    tab.setText(title)
    tab.setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0, 0)
    addTab(newTab().setCustomView(tab))
}

fun TabLayout.updateTabAt(position: Int, @StringRes title: Int, @DrawableRes icon: Int, @LayoutRes customView: Int) {
    val tab = LayoutInflater.from(context).inflate(customView, this as ViewGroup, false) as TextView
    tab.setText(title)
    tab.setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0, 0)
    getTabAt(position)?.customView = tab
}

fun TabLayout.tabs(): List<TabLayout.Tab?> = (0..tabCount).map {
    getTabAt(it)
}
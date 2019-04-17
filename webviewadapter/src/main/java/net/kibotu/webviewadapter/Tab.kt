package net.kibotu.webviewadapter

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tab(
    val url: String,
    @StringRes val label: Int,
    @DrawableRes val icon: Int,
    @ColorRes val inactiveColor: Int,
    @ColorRes val activeColor: Int
)
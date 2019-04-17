package net.kibotu.webviewadapter

import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.webkit.WebView
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.adapter_tab_icon.view.*


open class WebViewPageAdapter(
    protected val webView: WebView,
    protected val tabLayout: TabLayout
) : PagerAdapter(), TabLayout.OnTabSelectedListener {

    protected val pages: MutableList<Tab> = mutableListOf()

    var currentItem: Int = 0
        set(value) {
            field = value
            log { "currentItem $value -> ${pages[value].url}" }
            webView.loadUrl(pages[value].url)
            tabLayout.getTabAt(value)?.select()
        }

    init {
        log { "init" }
        tabLayout.addOnTabSelectedListener(this)
    }

    protected fun populateTabs() {
        log { "populateTabs ${tabLayout.tabCount}" }
        for (i in 0 until tabLayout.tabCount) {
            val customView = LayoutInflater.from(tabLayout.context).inflate(R.layout.adapter_tab_icon, tabLayout, false)
            customView.label.setText(pages[i].label)
            customView.icon.setImageResource(pages[i].icon)

            val tab = tabLayout.getTabAt(i)
            tab?.customView = customView

            tab?.setTabColor(
                ContextCompat.getColor(
                    tabLayout.context,
                    if (currentItem == i) {
                        pages[i].activeColor
                    } else {
                        pages[i].inactiveColor
                    }
                )
            )
        }
    }

    // region PagerAdapter

    override fun isViewFromObject(view: View, `object`: Any): Boolean = true

    override fun getCount(): Int = pages.size

    override fun notifyDataSetChanged() {
        super.notifyDataSetChanged()
        log { "notifyDataSetChanged" }

        @Suppress("DEPRECATION")
        tabLayout.setTabsFromPagerAdapter(this)

        populateTabs()

        currentItem = 0
    }

    // endregion

    // region TabLayout.OnTabSelectedListener

    override fun onTabReselected(tab: TabLayout.Tab?) {
        log { "onTabReselected ${tab?.position}" }
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
        log { "onTabUnselected ${tab?.position}" }

        styleUnselectedTab(tab ?: return)
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        log { "onTabSelected ${tab?.position}" }

        styleSelectedTab(tab ?: return)

        if (currentItem != tab.position)
            currentItem = tab.position
    }

    // endregion

    // region styling tabs

    protected fun styleSelectedTab(tab: TabLayout.Tab) {
        log { "styleSelectedTab ${tab.position}" }
        tab.setTabColor(ContextCompat.getColor(tabLayout.context, pages[tab.position].activeColor))
    }

    protected fun styleUnselectedTab(tab: TabLayout.Tab) {
        log { "styleUnselectedTab ${tab.position}" }
        tab.setTabColor(ContextCompat.getColor(tabLayout.context, pages[tab.position].inactiveColor))
    }

    protected fun TabLayout.Tab.setTabColor(@ColorInt color: Int) = customView?.apply {
        icon.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
        label.setTextColor(color)
    }

    // endregion

    fun add(tab: Tab) {
        log { "add ${tab.resNameString(tabLayout.context)}" }
        pages.add(tab)
    }
}
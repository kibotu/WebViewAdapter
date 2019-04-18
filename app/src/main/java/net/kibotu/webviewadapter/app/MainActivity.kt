package net.kibotu.webviewadapter.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.exozet.android.core.extensions.onClick
import kotlinx.android.synthetic.main.activity_main.*
import net.kibotu.logger.LogcatLogger
import net.kibotu.logger.Logger
import net.kibotu.logger.Logger.logv
import net.kibotu.webviewadapter.Tab
import net.kibotu.webviewadapter.WebViewPageAdapter

/**
 * Created by [Jan Rabe](https://about.me/janrabe).
 */
class MainActivity : AppCompatActivity() {

    lateinit var adapter: WebViewPageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Logger.addLogger(LogcatLogger())

        addPages()

        loadInitialWebViewUrl()

        addDebugButtons()
    }

    private fun addPages() {
        adapter = WebViewPageAdapter(webView, tabLayout)

        adapter.onLoadUrl = { logv("onLoading $it") }

        adapter.addAll(
            Tab("https://github.com/kibotu/RecyclerViewPresenter", R.string.tab_1, R.drawable.ic_edit_black_24dp, R.color.inactiveColorTint, R.color.colorPrimary),
            Tab("https://github.com/kibotu/Heart-Rate-Ometer", R.string.tab_2, R.drawable.ic_edit_black_24dp, R.color.inactiveColorTint, R.color.colorPrimary),
            Tab("https://github.com/kibotu/Android-PGP", R.string.tab_3, R.drawable.ic_edit_black_24dp, R.color.inactiveColorTint, R.color.colorPrimary),
            Tab("https://github.com/kibotu/StreamingAndroidLogger", R.string.tab_4, R.drawable.ic_edit_black_24dp, R.color.inactiveColorTint, R.color.colorPrimary),
            Tab("https://github.com/kibotu/KalmanRx", R.string.tab_5, R.drawable.ic_edit_black_24dp, R.color.inactiveColorTint, R.color.colorPrimary)
        )

        adapter.notifyDataSetChanged()
    }

    private fun loadInitialWebViewUrl() {

        val customInitialPage = false

        if (customInitialPage)
            webView.loadUrl("https://www.google.com")
        else
            adapter.selectCurrentItem(0)
    }

    private fun addDebugButtons() {
        // selecting tab without loading url, required for selecting tabs on in-webview-navigation

        selectPreviousTab.onClick {
            adapter.selectCurrentItem(adapter.currentItem - 1, false)
        }

        selectNextTab.onClick {
            adapter.selectCurrentItem(adapter.currentItem + 1, false)
        }
    }

    override fun onBackPressed() {

        if (webView.canGoBack())
            webView.goBack()
        else
            super.onBackPressed()
    }
}
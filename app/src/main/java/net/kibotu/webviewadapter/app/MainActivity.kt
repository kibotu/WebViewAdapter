package net.kibotu.webviewadapter.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.kibotu.logger.LogcatLogger
import net.kibotu.logger.Logger
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

        adapter = WebViewPageAdapter(webView, tabLayout)

        adapter.add(Tab("https://github.com/kibotu/RecyclerViewPresenter", R.string.tab_1, R.drawable.ic_edit_black_24dp, R.color.inactiveColorTint, R.color.colorPrimary))
        adapter.add(Tab("https://github.com/kibotu/Heart-Rate-Ometer", R.string.tab_2, R.drawable.ic_edit_black_24dp, R.color.inactiveColorTint, R.color.colorPrimary))
        adapter.add(Tab("https://github.com/kibotu/Android-PGP", R.string.tab_3, R.drawable.ic_edit_black_24dp, R.color.inactiveColorTint, R.color.colorPrimary))
        adapter.add(Tab("https://github.com/kibotu/StreamingAndroidLogger", R.string.tab_4, R.drawable.ic_edit_black_24dp, R.color.inactiveColorTint, R.color.colorPrimary))
        adapter.add(Tab("https://github.com/kibotu/KalmanRx", R.string.tab_5, R.drawable.ic_edit_black_24dp, R.color.inactiveColorTint, R.color.colorPrimary))

        adapter.notifyDataSetChanged()
    }

    override fun onBackPressed() {

        if (webView.canGoBack())
            webView.goBack()
        else
            super.onBackPressed()
    }
}
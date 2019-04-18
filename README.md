[![Donation](https://img.shields.io/badge/by%20me%20a%20coffee-brightgreen.svg)](https://www.paypal.me/janrabe/5) [![About Jan Rabe](https://img.shields.io/badge/about-me-green.svg)](https://about.me/janrabe)
# WebViewAdapter [![](https://jitpack.io/v/kibotu/WebViewAdapter.svg)](https://jitpack.io/#kibotu/WebViewAdapter) [![](https://jitpack.io/v/kibotu/WebViewAdapter/month.svg)](https://jitpack.io/#kibotu/WebViewAdapter) [![Javadoc](https://img.shields.io/badge/javadoc-SNAPSHOT-green.svg)](https://jitpack.io/com/github/kibotu/WebViewAdapter/master-SNAPSHOT/javadoc/index.html) [![Build Status](https://travis-ci.org/kibotu/WebViewAdapter.svg)](https://travis-ci.org/kibotu/WebViewAdapter)  [![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=15) [![Gradle Version](https://img.shields.io/badge/gradle-5.4.0-green.svg)](https://docs.gradle.org/current/release-notes) [![Kotlin](https://img.shields.io/badge/kotlin-1.3.30-green.svg)](https://kotlinlang.org/) [![GitHub license](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://raw.githubusercontent.com/kibotu/WebViewAdapter/master/LICENSE) [![androidx](https://img.shields.io/badge/androidx-brightgreen.svg)](https://developer.android.com/topic/libraries/support-library/refactor)

ActionBar like usability for a webview. Also modular handling of uri event handler.

### How to install

	repositories {
	    maven {
	        url "https://jitpack.io"
	    }
	}

	dependencies {

        implementation 'com.github.kibotu:WebViewAdapter:-SNAPSHOT'
    }

### How to use

1 [prepare layout](app/src/main/res/layout/activity_main.xml#L10-L41)

    <androidx.constraintlayout.widget.ConstraintLayout>
        <WebView/>
        <com.google.android.material.tabs.TabLayout/>
    </androidx.constraintlayout.widget.ConstraintLayout>

2 [add adapter pages](app/src/main/java/net/kibotu/webviewadapter/app/MainActivity.kt#L34-L46)

     adapter = WebViewPageAdapter(webView, tabLayout)

     adapter.add(Tab("https://github.com/kibotu/RecyclerViewPresenter", R.string.tab_1, R.drawable.ic_edit_black_24dp, R.color.inactiveColorTint, R.color.colorPrimary))
     adapter.add(Tab("https://github.com/kibotu/Heart-Rate-Ometer", R.string.tab_2, R.drawable.ic_edit_black_24dp, R.color.inactiveColorTint, R.color.colorPrimary))
     adapter.add(Tab("https://github.com/kibotu/Android-PGP", R.string.tab_3, R.drawable.ic_edit_black_24dp, R.color.inactiveColorTint, R.color.colorPrimary))
     adapter.add(Tab("https://github.com/kibotu/StreamingAndroidLogger", R.string.tab_4, R.drawable.ic_edit_black_24dp, R.color.inactiveColorTint, R.color.colorPrimary))
     adapter.add(Tab("https://github.com/kibotu/KalmanRx", R.string.tab_5, R.drawable.ic_edit_black_24dp, R.color.inactiveColorTint, R.color.colorPrimary))

     adapter.notifyDataSetChanged()

3 [load intial url](app/src/main/java/net/kibotu/webviewadapter/app/MainActivity.kt#L51-L56)

    adapter.selectCurrentItem(0)

(optional) [add onLoading Url callback](app/src/main/java/net/kibotu/webviewadapter/app/MainActivity.kt#L36)

    adapter.onLoadUrl = { logv("onLoading $it") }

4 profit :)

### License
<pre>
Copyright 2019 Jan Rabe

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
</pre>
package net.kibotu.webviewadapter.uriHandler

import android.net.Uri

interface UriHandler {
    fun onUri(uri: Uri): Boolean
}
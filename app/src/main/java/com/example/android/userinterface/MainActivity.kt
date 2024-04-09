package com.example.android.userinterface

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TextBox1.setText("")
        val myWebView: WebView = findViewById(R.id.webview)

        // Set WebViewClient
        myWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }

        // Enable JavaScript
        val webSettings = myWebView.settings
        webSettings.textZoom = 125 // where 100 is the default value.
        webSettings.javaScriptEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true
        webSettings.setSupportZoom(true)
        webSettings.builtInZoomControls = true
        webSettings.displayZoomControls = false
        webSettings.setAppCacheEnabled(true)
        webSettings.databaseEnabled = true
        webSettings.domStorageEnabled = true

        // Load a URL
        myWebView.loadUrl("http://safeway.com")

        imageButton.setOnClickListener {
            myWebView.loadUrl("www.safeway.com")
        }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
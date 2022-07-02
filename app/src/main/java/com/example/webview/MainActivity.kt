package com.example.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    private lateinit var btnsearch: AppCompatButton
    private lateinit var editText: AppCompatEditText
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initview()
    }

    private fun initview() {

        btnsearch = findViewById(R.id.btnSearch)
        editText = findViewById(R.id.edit_text)
        webView = findViewById(R.id.web_view)
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)
        btnsearch.setOnClickListener {
            searchSide()
        }
    }

    private fun searchSide() {
        val query: String = editText.text.toString().trim()
        if (query.isNotEmpty()){
            webView.loadUrl("https://$query")

        }
        else{
            Toast.makeText(this, "enter_quary", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack()

        }
        else{
            super.onBackPressed()
        }
    }

}
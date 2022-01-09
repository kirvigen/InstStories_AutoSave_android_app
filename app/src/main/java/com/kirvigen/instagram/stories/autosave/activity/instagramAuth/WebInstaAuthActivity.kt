package com.kirvigen.instagram.stories.autosave.activity.instagramAuth

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kirvigen.instagram.stories.autosave.databinding.ActivityWebInstaAuthBinding
import android.webkit.WebSettings

class WebInstaAuthActivity : AppCompatActivity() {

    private val loginUrl = "https://www.instagram.com/login"
    private val headers = mapOf(
        "user-agent" to "Mozilla/5.0 (Linux; Android 8.0.0; SM-G960F Build/R16NW) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.84 Mobile Safari/537.36"
    )

    private var binding: ActivityWebInstaAuthBinding? = null

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebInstaAuthBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val webSettings: WebSettings = binding?.webContainer?.settings ?: return
        webSettings.javaScriptEnabled = true
        binding?.webContainer?.loadUrl(loginUrl, headers)

        binding?.webContainer?.webViewClient = InstagramWebClient { cookies ->
            successAuth(cookies)
        }
    }

    private fun successAuth(cookies: String) {
        val intent = Intent().apply {
            putExtra(AuthInstagramResultCallback.KEY_RESULT_INSTAGRAM_COOKIES, cookies)
        }
        setResult(Activity.RESULT_OK, intent)
    }
}
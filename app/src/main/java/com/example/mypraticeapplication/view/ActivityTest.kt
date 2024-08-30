package com.example.mypraticeapplication.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.TestActivityBinding
import com.example.mypraticeapplication.view.base.BaseActivity


open class ActivityTest: BaseActivity()  {

    private lateinit var binding: TestActivityBinding

    var data : String = ""
 //   private val documentProfileVerificationViewModel by lazy { DocumentProfileVerificationViewModel( this,binding) }

    @SuppressLint("DiscouragedPrivateApi", "SimpleDateFormat", "SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TestActivityBinding.inflate(layoutInflater)
     //   binding.viewModel = documentProfileVerificationViewModel
     //   binding.lifecycleOwner = this
        setContentView(binding.root)


        val formWebView: WebView = findViewById(R.id.webview)
        formWebView.settings.javaScriptEnabled = true
        formWebView.loadUrl("https://squeamish.co.in/MobileApp/RCUVerification?UserId=74&BranchId=1&Token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJKV1RTZXJ2aWNlQWNjZXNzVG9rZW4iLCJqdGkiOiJiMjE0NDI5ZS1kYzE2LTRkNGUtODA2MS0wYTFlNWQ1NmIzOTIiLCJpYXQiOiIxNC0wOC0yMDI0IDE3OjI0OjA4IiwiVXNlckxvZ0lkIjoiMTEwNDYxIiwiVXNlcklkIjoiNzQiLCJFbXBsb3llZUlkIjoiMTM0IiwiQnVzaW5lc3NJZCI6IjIwIiwiZXhwIjoxNzU1MTkyMjQ4LCJpc3MiOiJKV1RBdXRoZW50aWNhdGlvblNlcnZlciIsImF1ZCI6IkpXVFNlcnZpY2VQb3N0bWFuQ2xpZW50In0.8DCP2BMD8B5wT6RdzBjGbXgTP2wLgzZi_IFEQJ5Tp0I&FIRequestId=185")
    }


}
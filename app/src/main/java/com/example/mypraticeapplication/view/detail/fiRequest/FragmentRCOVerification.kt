package com.example.mypraticeapplication.view.detail.fiRequest

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.example.mypraticeapplication.databinding.FragmentRcoVerificationBinding
import com.example.mypraticeapplication.databinding.FragmentRcuVerificationBinding
import com.example.mypraticeapplication.interfaces.FragmentLifecycleInterface
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetVerificationDetailData
import com.example.mypraticeapplication.view.base.BaseFragment
import com.example.mypraticeapplication.view.detail.FragmentRCUVerification
import com.example.mypraticeapplication.viewmodel.verificationDetail.RCOVerificationViewModel
import com.example.mypraticeapplication.viewmodel.verificationDetail.RCUVerificationViewModel

class FragmentRCOVerification: BaseFragment(), FragmentLifecycleInterface {

    private var _binding: FragmentRcoVerificationBinding? = null
    // This property is only valid between onCreateView and
    private val binding get() = _binding!!
    var data : String = ""
    private val rcuVerificationViewModel by lazy { RCOVerificationViewModel( context as Activity,binding) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentRcoVerificationBinding.inflate(inflater, container, false)
        binding.viewModel = rcuVerificationViewModel
        binding.lifecycleOwner = this
        rcuVerificationViewModel.init(context)
        setObserver()
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setObserver() {


        rcuVerificationViewModel.isLoading.observe(requireActivity()) { isLoading ->
            if (isLoading && isAdded) showProgressbar()
            else if (!isLoading && isAdded) hideProgressbar()
        }


        rcuVerificationViewModel.webViewURL.observeForever {
            if (!it.isNullOrEmpty()){

                binding.webView.getSettings().javaScriptEnabled = true;

                showProgressbar()
                binding.webView.setWebViewClient(object : WebViewClient() {
                    @Deprecated("Deprecated in Java", ReplaceWith(
                        "Toast.makeText(activity, description, Toast.LENGTH_SHORT).show()",
                        "android.widget.Toast",
                        "android.widget.Toast"
                    )
                    )
                    override fun onReceivedError(
                        view: WebView,
                        errorCode: Int,
                        description: String,
                        failingUrl: String
                    ) {
                        Toast.makeText(activity, description, Toast.LENGTH_SHORT).show()
                    }

                    override fun onReceivedError(
                        view: WebView,
                        req: WebResourceRequest,
                        rerr: WebResourceError
                    ) {
                        // Redirect to deprecated method, so you can use it in all SDK versions
                        onReceivedError(
                            view,
                            rerr.errorCode,
                            rerr.description.toString(),
                            req.url.toString()
                        )
                    }

                    override fun onPageFinished(view: WebView?, url: String?) {
                        super.onPageFinished(view, url)
                        hideProgressbar()
                    }
                })

                binding.webView.loadUrl(it.toString())
            }
        }
    }

    companion object {

        fun newInstance(selectedData: GetVerificationDetailData?): FragmentRCOVerification {
            val bundle = Bundle()
            //  bundle.putSerializable(DATA, selectedData)
            val fragmentRCOVerification = FragmentRCOVerification()
            fragmentRCOVerification.arguments = bundle
            return fragmentRCOVerification
        }
    }

    override fun onPauseFragment() {

    }

    override fun onResumeFragment(s: String?) {

    }
}
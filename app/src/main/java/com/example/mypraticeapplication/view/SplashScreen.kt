package com.example.mypraticeapplication.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.DecelerateInterpolator
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.SplashscreenBinding
import com.example.mypraticeapplication.uttils.Session
import com.example.mypraticeapplication.view.menu.DashboardActivity


@SuppressLint("CustomSplashScreen")
class SplashScreen : Fragment()  {

    private var _binding: SplashscreenBinding? = null
    var session: Session? = null;

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = SplashscreenBinding.inflate(inflater, container, false)
         session = context?.let { Session(it) }!!;
        setDelay()


        val fadeIn: Animation = AlphaAnimation(0f, 1f)
        fadeIn.interpolator = DecelerateInterpolator() //add this
        fadeIn.duration = 3000

        val fadeOut: Animation = AlphaAnimation(1f, 0f)
        fadeOut.interpolator = AccelerateInterpolator() //and this
        fadeOut.startOffset = 2000
        fadeOut.duration = 2000

        val animation = AnimationSet(false) //change to false
        animation.addAnimation(fadeOut)
        animation.addAnimation(fadeIn)
        binding.ivLogo.setAnimation(animation)


        binding.ivLogo.startAnimation(animation);

        return binding.root
    }



    private fun setDelay() {
        Handler(Looper.getMainLooper()).postDelayed({
            if (!session!!.isLoggedIn) {
                findNavController().navigate(R.id.action_SplashScreen_to_LoginFragment)
            } else {
                val iDashboard = Intent(activity,DashboardActivity::class.java)
                iDashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                iDashboard.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                startActivity(iDashboard)
                requireActivity().finish()
            }
        }, 2500)
    }
}
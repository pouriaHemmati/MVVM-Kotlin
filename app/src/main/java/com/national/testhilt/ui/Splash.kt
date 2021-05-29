package com.national.testhilt.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.DecelerateInterpolator

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.national.testhilt.databinding.ActSplashBinding
import com.national.testhilt.ui.base.BaseActivity
import com.national.testhilt.utils.SPLASH_DELY
import com.national.testhilt.utils.VIEW_DELAY

class Splash : BaseActivity() {

    private lateinit var binding: ActSplashBinding
    private var decelerateInterpolator = DecelerateInterpolator()


    override fun initViewBinding() {
        binding = ActSplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigateToMainScreen()

        binding.txtAboutSplash?.let { ViewCompat.animate(it) }
            ?.scaleY(1f)?.scaleX(1f)
            ?.setStartDelay(((VIEW_DELAY) + 500).toLong())
            ?.setDuration(500)
            ?.setInterpolator(decelerateInterpolator)
            ?.start()
    }

    override fun observeViewModel() {

    }

   private fun navigateToMainScreen(){
       Handler().postDelayed({
           val nextScreenIntent = Intent(this, MainActivity::class.java)
           startActivity(nextScreenIntent)
           finish()
       }, SPLASH_DELY.toLong())
   }



}
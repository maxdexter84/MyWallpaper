package ru.maxdexter.mywallpaper.ui.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import ru.maxdexter.mywallpaper.MainActivity
import ru.maxdexter.mywallpaper.R
import ru.maxdexter.mywallpaper.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hideStatusBar()

        val splashAnimation = AnimationUtils.loadAnimation(this, R.anim.animation)
        binding.tvAppName.animation = splashAnimation
        splashAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                //
            }

            override fun onAnimationEnd(animation: Animation?) {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            }

            override fun onAnimationRepeat(animation: Animation?) {
                //
            }
        })


    }

    private fun hideStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            @Suppress("DEPRECATION")
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN

            )
        }
    }
}
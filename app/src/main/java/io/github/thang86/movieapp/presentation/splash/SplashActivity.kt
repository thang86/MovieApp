package io.github.thang86.movieapp.presentation.splash

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.DecelerateInterpolator
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import io.github.thang86.movieapp.R
import io.github.thang86.movieapp.presentation.home.HomeActivity
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
//    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        setupAnimationOfViews()

        GlobalScope.launch {
            delay(5000)
            HomeActivity.start(this@SplashActivity)
            supportFinishAfterTransition()
        }

    }

    private fun setupAnimationOfViews() {
        imageViewForeground.post {
            ObjectAnimator.ofFloat(imageViewForeground, "y", imageViewForeground.height.toFloat(), 0f).apply {
                duration = 1000
                interpolator = OvershootInterpolator()
                start()
            }
        }

        img_logo.post {
            val scaleX = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 1.3f, 1.0f)
            val scaleY = PropertyValuesHolder.ofFloat("scaleY", 1.0f, 1.3f, 1.0f)
            ObjectAnimator.ofPropertyValuesHolder(img_logo, scaleX, scaleY).apply {
                duration = 1000
                startDelay = 750L
                start()
                doOnEnd { (img_logo.drawable as AnimationDrawable).start() }
            }
        }

        text.post {
            ObjectAnimator.ofFloat(text, "alpha", 0f, 1f).apply {
                duration = 1250
                startDelay = 1750L
                interpolator = DecelerateInterpolator(1.2f)
                start()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        (img_logo.drawable as AnimationDrawable).stop()
    }

}
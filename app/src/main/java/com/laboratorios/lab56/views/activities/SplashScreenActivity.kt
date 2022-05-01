package com.laboratorios.lab56.views.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.laboratorios.lab56.R
import com.laboratorios.lab56.databinding.ActivitySplashScreenBinding
import java.io.IOException

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            super.onCreate(savedInstanceState)

            //Binding use to set View in the screen

            binding = ActivitySplashScreenBinding.inflate(layoutInflater)
            val view = binding.root
            setContentView(view)

            //Animation in the activity Code

            val animlogo = AnimationUtils.loadAnimation(this, R.anim.animation)
            val imgLogo: ImageView = binding.imgLogo
            imgLogo.startAnimation(animlogo)

            //Control the actions in the animation

            val intent = Intent(this, LoginActivity::class.java)
            animlogo.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {

                }

                override fun onAnimationEnd(animation: Animation?) {
                    startActivity(intent)
                    finish()
                }

                override fun onAnimationRepeat(animation: Animation?) {

                }
            })
        }
        catch (e:IOException){
            e.printStackTrace()
        }
    }
}
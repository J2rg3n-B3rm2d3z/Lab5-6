package com.laboratorios.lab56.views

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.laboratorios.lab56.R
import java.io.IOException

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_splash_screen)

            //Animation in the activity Code

            val animlogo = AnimationUtils.loadAnimation(this, R.anim.animation)
            val imgLogo: ImageView = findViewById(R.id.imgLogo)
            imgLogo.startAnimation(animlogo)

            val intent = Intent(this, MenuActivity::class.java)
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
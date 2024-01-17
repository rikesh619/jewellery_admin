package com.brjewels.admin.android.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brjewels.admin.android.R
import com.brjewels.admin.android.activity.authentication.LoginActivity
import java.util.Timer
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {
    private val timerDuration : Long = 2500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        navigateToNextScreen()
    }

    private fun navigateToNextScreen() {
        Timer().schedule(timerTask {
            goToLoginScreen()
        }, timerDuration)
    }

    private fun goToLoginScreen() {
        val intent = Intent(this, LoginActivity :: class.java)
        startActivity(intent)
    }
}
package lupedapps.com.kiedywolne.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import lupedapps.com.kiedywolne.R


class SplashActivity : AppCompatActivity() {

    private val SPLASH_DISPLAY_LENGTH = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar!!.hide()
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        Handler().postDelayed({ goToNextActivity(Intent(this, MainActivity::class.java)) }, SPLASH_DISPLAY_LENGTH.toLong())
    }

    private fun goToNextActivity(intent: Intent) {
        startActivity(intent)
        finish()
    }
}

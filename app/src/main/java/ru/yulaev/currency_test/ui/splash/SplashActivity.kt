package ru.yulaev.currency_test.ui.splash

import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import android.widget.Toast
import ru.yulaev.currency_test.R
import ru.yulaev.currency_test.ui.BaseActivity
import ru.yulaev.currency_test.ui.main.MainActivity

class SplashActivity : BaseActivity(), ISplash {
    @InjectPresenter
    lateinit var presenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
    }

    override fun openNext() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onError(errorText: String) {
        Toast.makeText(this, errorText, Toast.LENGTH_LONG).show()
    }
}
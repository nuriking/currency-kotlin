package ru.yulaev.currency_test.app

import android.support.multidex.MultiDexApplication
import android.os.Handler
import android.os.Looper
import ru.yulaev.currency_test.Constant
import ru.yulaev.currency_test.network.NetworkModule
import ru.yulaev.currency_test.network.interseptor.NetworkNotAvailableInterceptor
import ru.yulaev.currency_test.ui.BaseActivity

class App : MultiDexApplication(), NetworkNotAvailableInterceptor.IOnNetworkIsNotAvailableFireListener {
    companion object {
        private lateinit var instance: App
        private lateinit var appComponent: AppComponent
        private lateinit var currentActivity: BaseActivity
    }

    init {
        instance = this

        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule(getUrl(), this))
                .build()
        appComponent.inject(this)
    }

    fun get(): App {
        return instance
    }

    fun getAppComponent(): AppComponent {
        return appComponent
    }

    fun setCurrentActivity(activity: BaseActivity) {
        currentActivity = activity
    }

    fun getUrl(): String {
        return Constant.API_ROOT
    }

    override fun call(e: Throwable) {
        val handler = Handler(Looper.getMainLooper()) { message ->
            if (currentActivity != null) {
                currentActivity.showNetworkFailureModal()
            }
            false
        }
        val message = handler.obtainMessage()
        message.sendToTarget()
    }

}
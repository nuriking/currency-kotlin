package ru.yulaev.currency_test.ui.splash

import android.annotation.SuppressLint
import com.arellomobile.mvp.InjectViewState
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.yulaev.currency_test.app.App
import ru.yulaev.currency_test.ui.BasePresenter
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@InjectViewState
class SplashPresenter : BasePresenter<ISplash>() {

    @Inject
    lateinit var model: SplashModel

    init {
        App().getAppComponent().inject(this)
    }

    @SuppressLint("CheckResult")
    override fun attachView(view: ISplash?) {
        super.attachView(view)
        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::openNext)
    }

    private fun openNext(long: Long){
        getView().openNext()
    }

    private fun onError(t: Throwable) {
        getView().onError(t.localizedMessage)
    }
}
package ru.yulaev.currency_test.main

import android.annotation.SuppressLint
import android.util.Log
import com.arellomobile.mvp.InjectViewState
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.yulaev.currency_test.app.App
import ru.yulaev.currency_test.model.Stock
import ru.yulaev.currency_test.ui.BasePresenter
import ru.yulaev.currency_test.ui.main.IMain
import ru.yulaev.currency_test.ui.main.MainModel
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import io.reactivex.disposables.Disposable

@InjectViewState
class MainPresenter : BasePresenter<IMain>() {

    @Inject
    lateinit var model: MainModel

    var disposable: Disposable? = null

    init {
        App().getAppComponent().inject(this)
    }

    override fun attachView(view: IMain?) {
        super.attachView(view)
        disposable = Observable.interval(1000, 5000,
                TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::getCurrency, this::onError)
    }

    @SuppressLint("CheckResult")
    fun getCurrency(long: Long) {
        model.getCurrencyModels()
                .doOnSubscribe { getView().onShowLoading() }
                .doFinally { getView().onHideLoading() }
                .subscribe(this::onSuccessLoadCurrencyModels, this::onError)
    }


    private fun onSuccessLoadCurrencyModels(stock: Stock) {
        getView().fillLayout(stock.stock)
    }

    private fun onError(throwable: Throwable) {
        getView().onError(throwable.message.toString())
    }
}
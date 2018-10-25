package ru.yulaev.currency_test.ui.main

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.yulaev.currency_test.model.Stock
import ru.yulaev.currency_test.network.APIManager
import javax.inject.Inject

class MainModel @Inject constructor(private var apiManager: APIManager) {
    fun getCurrencyModels(): Observable<Stock> {
        return this.apiManager.getCurrencyModels()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}
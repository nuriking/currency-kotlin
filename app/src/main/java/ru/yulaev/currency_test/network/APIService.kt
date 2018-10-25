package ru.yulaev.currency_test.network

import io.reactivex.Observable
import retrofit2.http.GET
import ru.yulaev.currency_test.model.Stock

interface APIService {
    @GET("stocks.json")
    fun getCurrencyModels(): Observable<Stock>
}
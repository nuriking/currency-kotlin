package ru.yulaev.currency_test.ui.main

import ru.yulaev.currency_test.model.CurrencyModel
import ru.yulaev.currency_test.ui.IBaseView

interface IMain : IBaseView {
    fun onShowLoading()

    fun onHideLoading()

    fun fillLayout(currencyModel: List<CurrencyModel>)
}
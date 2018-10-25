package ru.yulaev.currency_test.ui

import com.arellomobile.mvp.MvpView

interface IBaseView : MvpView {
    fun onError(errorText: String)
}

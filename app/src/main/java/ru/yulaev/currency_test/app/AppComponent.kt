package ru.yulaev.currency_test.app

import dagger.Component
import ru.yulaev.currency_test.main.MainPresenter
import ru.yulaev.currency_test.network.NetworkModule
import ru.yulaev.currency_test.ui.splash.SplashPresenter
import javax.inject.Singleton


@Singleton
@Component(modules = [(NetworkModule::class), (AppModule::class)])

interface AppComponent {
    fun inject(app: App)

    fun inject(mainPresenter: MainPresenter)

    fun inject(splashPresenter: SplashPresenter)
}
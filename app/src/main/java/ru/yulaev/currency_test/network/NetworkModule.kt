package ru.yulaev.currency_test.network

import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import ru.yulaev.currency_test.network.interseptor.NetworkNotAvailableInterceptor
import java.util.ArrayList
import javax.inject.Inject
import javax.inject.Singleton

@Module
class NetworkModule {
    private val baseUrl: String
    private val IOnNetworkIsNotAvailableFireListener: NetworkNotAvailableInterceptor.IOnNetworkIsNotAvailableFireListener

    constructor(url: String,  iNetworkIsNotAvailableInterceptorCallback : NetworkNotAvailableInterceptor.IOnNetworkIsNotAvailableFireListener ) {
        baseUrl = url
        this.IOnNetworkIsNotAvailableFireListener = iNetworkIsNotAvailableInterceptorCallback
    }

    @Provides
    @Singleton
    @Inject
    fun provideApiManager(): APIManager {
        val interceptors = ArrayList<Interceptor>()
        interceptors.add(NetworkNotAvailableInterceptor(IOnNetworkIsNotAvailableFireListener))
        return APIManager(baseUrl, interceptors)
    }

}

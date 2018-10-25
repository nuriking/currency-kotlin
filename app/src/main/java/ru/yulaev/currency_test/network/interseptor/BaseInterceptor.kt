package ru.yulaev.currency_test.network.interseptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

open class BaseInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = beforeRequest(chain.request())
        val response = chain.proceed(request)
        return if (response.isSuccessful) {
            onResponse(response)
        } else {
            onError(response)
        }
    }

    private fun beforeRequest(request: Request): Request {
        return request
    }

    private fun onResponse(response: Response): Response {
        return response
    }

    protected open fun onError(response: Response): Response {
        return response
    }
}

package com.gmail.shima.zeinalii.dev.weatherforecast.data.api

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */

/**
 * is used in #NetworkModule for handling header
 */
class AuthInterceptor(private val accessToken: String) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().addHeader(
            "Authorization", "key $accessToken"
        ).build()
        return chain.proceed(request)
    }
}
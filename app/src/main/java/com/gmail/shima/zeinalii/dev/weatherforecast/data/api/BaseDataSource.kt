package com.gmail.shima.zeinalii.dev.weatherforecast.data.api

import retrofit2.Response
import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.Result

/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
abstract class BaseDataSource {
    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Result.success(body)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Result<T> {
        return Result.error("Network call has failed because: $message")
    }
}
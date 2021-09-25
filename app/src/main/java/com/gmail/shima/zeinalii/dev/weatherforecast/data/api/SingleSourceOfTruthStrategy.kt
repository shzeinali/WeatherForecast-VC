package com.gmail.shima.zeinalii.dev.weatherforecast.data.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import kotlinx.coroutines.Dispatchers
import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.Result
import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.Result.Status.SUCCESS
import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.Result.Status.ERROR

/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
fun <T, A> resultLiveData(
    databaseQuery: () -> LiveData<T>,
    networkCall: suspend () -> Result<A>,
    deleteOldData: suspend () -> Unit,
    saveCallResult: suspend (A) -> Unit
): LiveData<Result<T>> =
    liveData(Dispatchers.IO) {
        emit(Result.loading())
        val source = databaseQuery.invoke().map { Result.success(it) }
        emitSource(source)

        val responseStatus = networkCall.invoke()
        if (responseStatus.status == SUCCESS) {
            deleteOldData()
            saveCallResult(responseStatus.data!!)
        } else if (responseStatus.status == ERROR) {
            emit(Result.error(responseStatus.message!!))
            emitSource(source)
        }
    }
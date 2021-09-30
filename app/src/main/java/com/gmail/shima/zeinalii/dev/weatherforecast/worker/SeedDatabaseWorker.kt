package com.gmail.shima.zeinalii.dev.weatherforecast.worker

import android.content.Context
import android.util.Log
import com.gmail.shima.zeinalii.dev.weatherforecast.data.db.WFDatabase
import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.Forecast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */

/**
 * is used in #WFDatabase for inserting data for the first time in WFDatabase
 */
//class SeedDatabaseWorker(
//    context: Context,
//    workerParams: WorkerParameters
//) : CoroutineWorker(context, workerParams) {
//    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
//        try {
//            val filename = inputData.getString(KEY_FILENAME)
//            if (filename != null) {
//                applicationContext.assets.open(filename).use { inputStream ->
//                    JsonReader(inputStream.reader()).use { jsonReader ->
//                        val type = object : TypeToken<List<Forecast>>() {}.type
//                        val forecastList: List<Forecast> = Gson().fromJson(jsonReader, type)
//
//                        val database = WFDatabase.getInstance(applicationContext)
//                        database.forecastDao().insertForecasts(forecastList)
//
//                        Result.success()
//                    }
//                }
//            } else {
//                Log.e(TAG, "Error seeding database, no valid filename")
//                Result.failure()
//            }
//        } catch (ex: Exception) {
//            Log.e(TAG, "Error seeding database", ex)
//            Result.failure()
//        }
//    }
//
//    companion object {
//        private const val TAG = "SeedDatabaseWorker"
//        const val KEY_FILENAME = "DATA_FILENAME"
//    }
//}
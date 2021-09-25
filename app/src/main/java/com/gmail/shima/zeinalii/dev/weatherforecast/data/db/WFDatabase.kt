package com.gmail.shima.zeinalii.dev.weatherforecast.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.Forecast
import com.gmail.shima.zeinalii.dev.weatherforecast.utilities.DATABASE_NAME


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */

@Database(entities = [Forecast::class], version = 1, exportSchema = false)
abstract class WFDatabase : RoomDatabase() {

    abstract fun forecastDao(): ForecastDao

    companion object {

        @Volatile
        private var instance: WFDatabase? = null

        fun getInstance(context: Context): WFDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): WFDatabase {
            return Room.databaseBuilder(context, WFDatabase::class.java, DATABASE_NAME)
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        /** here we can add data for first time in db with workManager*/
//                        val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>()
//                            .setInputData(workDataOf(KEY_FILENAME to DATA_FILENAME))
//                            .build()
//                        WorkManager.getInstance(context).enqueue(request)
                    }
                })
                .build()
        }
    }
}
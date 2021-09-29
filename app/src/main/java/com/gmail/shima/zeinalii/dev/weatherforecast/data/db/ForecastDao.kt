package com.gmail.shima.zeinalii.dev.weatherforecast.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gmail.shima.zeinalii.dev.weatherforecast.data.models.Forecast
import kotlinx.coroutines.flow.Flow


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
@Dao
interface ForecastDao {

    @Query("SELECT * FROM forecasts")
    fun getForecasts(): LiveData<List<Forecast>>

    @Query("SELECT * FROM forecasts WHERE id = :forecastId")
    fun getForecast(forecastId: Int): Flow<Forecast>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForecasts(forecasts: List<Forecast>)

    @Query("DELETE FROM forecasts")
    suspend fun deleteForecasts()
}

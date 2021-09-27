package com.gmail.shima.zeinalii.dev.weatherforecast.di

import android.content.Context
import com.gmail.shima.zeinalii.dev.weatherforecast.data.db.ForecastDao
import com.gmail.shima.zeinalii.dev.weatherforecast.data.db.WFDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): WFDatabase {
        return WFDatabase.getInstance(context)
    }

    @Provides
    fun provideForecastDao(appDatabase: WFDatabase): ForecastDao {
        return appDatabase.forecastDao()
    }

}
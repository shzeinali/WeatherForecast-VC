package com.gmail.shima.zeinalii.dev.weatherforecast.di

import com.gmail.shima.zeinalii.dev.weatherforecast.data.api.WFService
import com.gmail.shima.zeinalii.dev.weatherforecast.data.dataSources.ForecastRemoteDS
import com.gmail.shima.zeinalii.dev.weatherforecast.utilities.BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            /** here we can set header for all Apis*/
//            .addInterceptor(AuthInterceptor(""))
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()


    @Singleton
    @Provides
    fun provideWFService(retrofit: Retrofit): WFService =
        retrofit.create(WFService::class.java)

    @Singleton
    @Provides
    fun provideForecastRemoteDataSource(service: WFService) =
        ForecastRemoteDS(service)
}
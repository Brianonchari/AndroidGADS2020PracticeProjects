package com.studycode.androidgads2020practiceprojects.di

import com.studycode.androidgads2020practiceprojects.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
class GoogleFormModule {
//
//    @Provides
//    fun providesFormUrl() = BuildConfig.FORM_URL
//
//    @Provides
//    @Singleton
//    fun providesOkHttpClient() = if(BuildConfig.DEBUG){
//        val loggingInterceptor = HttpLoggingInterceptor()
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
//        OkHttpClient.Builder()
//            .addInterceptor(loggingInterceptor)
//            .build()
//    }else OkHttpClient
//        .Builder()
//        .build()
//
//    @Provides
//    @Singleton
//    fun providesRetrofit(okHttpClient:OkHttpClient, FORM_URL:String):Retrofit =
//        Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl(FORM_URL)
//            .client(okHttpClient)
//            .build()

}
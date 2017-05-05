package com.pratamawijaya.blogreaderkotlin.app.di.module

import android.support.annotation.NonNull
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Converter.Factory
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by mnemonix
 * Date : Dec - 12/22/16
 * Project Name : BlogReaderKotlin
 */

@Module
@Singleton
class ApiModule {

  @Provides
  @NonNull
  fun provideRetrofit(okHttpClient: OkHttpClient,
      converterFactory: Factory): Retrofit {
    return Builder().baseUrl("https://pratamawijaya.com/api/")
        .client(okHttpClient)
        .addConverterFactory(converterFactory)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
  }

  @Provides
  @NonNull
  fun provideGson(): Gson = GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create()

  @Provides
  @NonNull
  fun provideConverter(gson: Gson): Factory = GsonConverterFactory.create(gson)


}
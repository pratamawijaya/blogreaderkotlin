package com.pratamawijaya.blogreaderkotlin.app.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Converter.Factory
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by mnemonix
 * Date : Dec - 12/22/16
 * Project Name : BlogReaderKotlin
 */

@Module
class ApiModule {

  @Provides fun provideRetrofit(okHttpClient: OkHttpClient,
      converterFactory: Factory): Retrofit {
    return Builder().baseUrl("")
        .client(okHttpClient)
        .addConverterFactory(converterFactory)
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build()
  }

  @Provides fun provideGson(): Gson {
    val gson = GsonBuilder().setDateFormat("").create()
    return gson
  }

  @Provides fun provideConverter(gson: Gson): Factory {
    return GsonConverterFactory.create(gson)
  }
}
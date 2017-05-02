package com.pratamawijaya.blogreaderkotlin.app.di

import com.pratamawijaya.blogreaderkotlin.app.di.scope.OkHttpInterceptors
import com.pratamawijaya.blogreaderkotlin.app.di.scope.OkHttpNetworkInterceptors
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by pratama
 * Date : May - 5/2/17
 * Project Name : BlogReaderKotlin
 */
@Module
class SupportModule {

  @Provides
  @OkHttpInterceptors
  fun provideOkHttpInterceptors(): List<Interceptor> {
    // create http logging
    val httpLogging = HttpLoggingInterceptor()
    httpLogging.level = HttpLoggingInterceptor.Level.BODY

    // add to interceptor list
    val interceptorList = arrayListOf<Interceptor>()
    interceptorList.add(httpLogging)
    return interceptorList
  }


  @Provides
  @OkHttpNetworkInterceptors
  fun provideOkHttpNetworkInterceptors(): List<Interceptor> {
    val interceptors = arrayListOf<Interceptor>()
    return interceptors
  }
}
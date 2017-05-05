package com.pratamawijaya.blogreaderkotlin.app.di.module

import com.pratamawijaya.blogreaderkotlin.app.di.scope.OkHttpInterceptors
import com.pratamawijaya.blogreaderkotlin.app.di.scope.OkHttpNetworkInterceptors
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import javax.inject.Singleton

/**
 * Created by pratama
 * Date : May - 5/2/17
 * Project Name : BlogReaderKotlin
 */
@Module
@Singleton
class SupportModule {

  @Provides
  @OkHttpInterceptors
  fun provideOkHttpInterceptors(): List<Interceptor> {
    // create http logging
    val httpLogging = HttpLoggingInterceptor()
    httpLogging.level = BODY

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
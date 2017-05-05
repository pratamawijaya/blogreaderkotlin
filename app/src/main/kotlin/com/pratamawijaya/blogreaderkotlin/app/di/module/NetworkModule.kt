package com.pratamawijaya.blogreaderkotlin.app.di.module

import android.app.Application
import com.pratamawijaya.blogreaderkotlin.app.di.scope.OkHttpInterceptors
import com.pratamawijaya.blogreaderkotlin.app.di.scope.OkHttpNetworkInterceptors
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.io.File

/**
 * Created by mnemonix
 * Date : Dec - 12/22/16
 * Project Name : BlogReaderKotlin
 */
@Module
class NetworkModule {

  companion object {
    fun createOkHttpClientBuilder(app: Application): OkHttpClient.Builder {
      return OkHttpClient.Builder().cache(createHttpCache(app))
    }

    fun createHttpCache(app: Application): Cache {
      val cacheDir = File(app.cacheDir, "cache_dir")
      return Cache(cacheDir, 50 * 1024 * 1024)
    }

    fun createOkHttpClient(okHttpClientBuilder: OkHttpClient.Builder,
        interceptors: List<Interceptor>, networkInterceptors: List<Interceptor>): OkHttpClient {

      for (intercept in interceptors) {
        okHttpClientBuilder.addInterceptor(intercept)
      }

      for (intercept in networkInterceptors) {
        okHttpClientBuilder.addNetworkInterceptor(intercept)
      }

      return okHttpClientBuilder.build()
    }
  }

  @Provides
  fun provideOkHttpClient(app: Application,
      @OkHttpInterceptors interceptors: List<Interceptor>,
      @OkHttpNetworkInterceptors networkInterceptors: List<Interceptor>): OkHttpClient {
    return createOkHttpClient(createOkHttpClientBuilder(app), interceptors, networkInterceptors)
  }

}
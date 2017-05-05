package com.pratamawijaya.blogreaderkotlin.presentation.di.module

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.pratamawijaya.blogreaderkotlin.BaseApp
import com.pratamawijaya.blogreaderkotlin.BuildConfig
import com.pratamawijaya.blogreaderkotlin.data.executor.JobExecutor
import com.pratamawijaya.blogreaderkotlin.data.feature.post.PostServices
import com.pratamawijaya.blogreaderkotlin.data.model.mapper.PostModelMapper
import com.pratamawijaya.blogreaderkotlin.domain.executor.PostExecutionThread
import com.pratamawijaya.blogreaderkotlin.domain.executor.ThreadExecutor
import com.pratamawijaya.blogreaderkotlin.domain.executor.UiThread
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import javax.inject.Singleton

/**
 * Created by pratama
 * Date : May - 5/5/17
 * Project Name : BlogReaderKotlin
 */
@Module
class AppModule constructor(private val application: BaseApp) {

  private val DISK_CACHE_SIZE = 50 * 1024 * 1024 // 50MB
  private val DISK_CACHE_FOLDER = "blog_apps"

  @Provides
  @Singleton
  fun provideApp(): BaseApp = application

  @Provides
  @Singleton
  fun provideApplicationContext(): Context = application

  @Provides
  @Singleton
  fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor = jobExecutor

  @Provides
  @Singleton
  fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread = uiThread


  @Provides @Singleton fun provideOkHttpClient(app: BaseApp): OkHttpClient {
    return createOkHttpClient(createOkHttpClientBuilder(app))
  }

  private fun createOkHttpClient(builder: OkHttpClient.Builder): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    builder.addInterceptor(httpLoggingInterceptor)
    return builder.build()
  }

  private fun createOkHttpClientBuilder(app: Application): OkHttpClient.Builder {
    return OkHttpClient.Builder().cache(createHttpCache(app))
  }

  private fun createHttpCache(application: Application): Cache {
    val cacheDir = File(application.cacheDir, DISK_CACHE_FOLDER)
    return Cache(cacheDir, DISK_CACHE_SIZE.toLong())
  }


  @Provides @Singleton fun provideRetrofit(okHttpClient: OkHttpClient,
      factory: Converter.Factory): Retrofit {
    return Retrofit.Builder().baseUrl("")
        .client(okHttpClient)
        .addConverterFactory(factory)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .validateEagerly(BuildConfig.DEBUG)
        .build()
  }

  @Provides @Singleton internal fun providesGson(): Gson {
    val gson = GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create()
    return gson
  }

  @Provides @Singleton internal fun provideConverter(gson: Gson): Converter.Factory {
    return GsonConverterFactory.create(gson)
  }

  @Provides @Singleton
  fun providePostServices(retrofit: Retrofit) = retrofit.create(PostServices::class.java)

  @Provides @Singleton
  fun providePostModelMapper() = PostModelMapper()

}
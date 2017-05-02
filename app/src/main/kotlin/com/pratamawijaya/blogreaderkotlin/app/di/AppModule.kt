package com.pratamawijaya.blogreaderkotlin.app.di

import android.app.Application
import com.pratamawijaya.blogreaderkotlin.data.executor.JobExecutor
import com.pratamawijaya.blogreaderkotlin.domain.executor.PostExecutionThread
import com.pratamawijaya.blogreaderkotlin.domain.executor.ThreadExecutor
import com.pratamawijaya.blogreaderkotlin.domain.executor.UiThread
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by mnemonix
 * Date : Dec - 12/22/16
 * Project Name : BlogReaderKotlin
 */

@Module
class AppModule constructor(private val application: Application) {

  @Provides fun provideApplication(): Application {
    return application
  }

  @Provides
  @Singleton fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
    return jobExecutor
  }

  @Provides
  @Singleton fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
    return uiThread
  }
}
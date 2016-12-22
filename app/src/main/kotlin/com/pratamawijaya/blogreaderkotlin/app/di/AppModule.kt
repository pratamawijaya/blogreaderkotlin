package com.pratamawijaya.blogreaderkotlin.app.di

import android.app.Application
import dagger.Module
import dagger.Provides

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

}
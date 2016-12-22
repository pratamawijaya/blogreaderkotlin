package com.pratamawijaya.blogreaderkotlin.presentation.ui.home.di

import android.app.Activity
import dagger.Module
import dagger.Provides

/**
 * Created by mnemonix
 * Date : Dec - 12/22/16
 * Project Name : BlogReaderKotlin
 */

@Module
class MainModule constructor(var activity: Activity) {

  @Provides fun provideActivity(): Activity {
    return activity
  }
}
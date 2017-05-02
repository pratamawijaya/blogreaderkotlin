package com.pratamawijaya.blogreaderkotlin.app

import android.app.Application
import android.content.Context
import com.pratamawijaya.blogreaderkotlin.BuildConfig
import com.pratamawijaya.blogreaderkotlin.app.di.AppComponent
import com.pratamawijaya.blogreaderkotlin.app.di.AppModule
import com.pratamawijaya.blogreaderkotlin.app.di.DaggerAppComponent
import timber.log.Timber
import timber.log.Timber.DebugTree

/**
 * Created by mnemonix
 * Date : Dec - 12/22/16
 * Project Name : BlogReaderKotlin
 */
class BaseApp : Application() {

  companion object {
    open fun get(context: Context): BaseApp = context.applicationContext as BaseApp
  }

  val appComponent: AppComponent
    get() = DaggerAppComponent.builder()
        .appModule(AppModule(this))
        .build()

  override fun onCreate() {
    super.onCreate()
    appComponent.inject(this)

    if (BuildConfig.DEBUG) Timber.plant(DebugTree())
  }

}
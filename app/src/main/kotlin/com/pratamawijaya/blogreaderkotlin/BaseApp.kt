package com.pratamawijaya.blogreaderkotlin

import android.app.Application
import android.content.Context
import com.pratamawijaya.blogreaderkotlin.presentation.di.component.AppComponent
import com.pratamawijaya.blogreaderkotlin.presentation.di.component.DaggerAppComponent
import com.pratamawijaya.blogreaderkotlin.presentation.di.module.AppModule
import timber.log.Timber
import timber.log.Timber.DebugTree

/**
 * Created by mnemonix
 * Date : Dec - 12/22/16
 * Project Name : BlogReaderKotlin
 */
class BaseApp : Application() {

    companion object {
        fun get(context: Context): BaseApp = context.applicationContext as BaseApp
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
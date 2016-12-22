package com.pratamawijaya.blogreaderkotlin.app.di

import com.pratamawijaya.blogreaderkotlin.app.BaseApp
import dagger.Component

/**
 * Created by mnemonix
 * Date : Dec - 12/22/16
 * Project Name : BlogReaderKotlin
 */

@Component(modules = arrayOf(AppModule::class, NetworkModule::class, ApiModule::class))
interface AppComponent {
  fun inject(baseApp: BaseApp)
}
package com.pratamawijaya.blogreaderkotlin.app.di.component

import com.pratamawijaya.blogreaderkotlin.app.BaseApp
import com.pratamawijaya.blogreaderkotlin.app.di.AppDependencies
import com.pratamawijaya.blogreaderkotlin.app.di.module.ApiModule
import com.pratamawijaya.blogreaderkotlin.app.di.module.AppModule
import com.pratamawijaya.blogreaderkotlin.app.di.module.NetworkModule
import com.pratamawijaya.blogreaderkotlin.app.di.module.SupportModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by mnemonix
 * Date : Dec - 12/22/16
 * Project Name : BlogReaderKotlin
 */

@Singleton
@Component(
    modules = arrayOf(AppModule::class, SupportModule::class, NetworkModule::class, ApiModule::class
    ))
interface AppComponent : AppDependencies {

  fun inject(baseApp: BaseApp)

}
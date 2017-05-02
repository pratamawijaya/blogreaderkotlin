package com.pratamawijaya.blogreaderkotlin.app.di

import com.pratamawijaya.blogreaderkotlin.app.BaseApp
import com.pratamawijaya.blogreaderkotlin.domain.executor.PostExecutionThread
import com.pratamawijaya.blogreaderkotlin.domain.executor.ThreadExecutor
import dagger.Component
import javax.inject.Singleton

/**
 * Created by mnemonix
 * Date : Dec - 12/22/16
 * Project Name : BlogReaderKotlin
 */

@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class, ApiModule::class,
    SupportModule::class))
interface AppComponent {

  fun inject(baseApp: BaseApp)

  fun threadExecutor(): ThreadExecutor

  fun postExecutionThread(): PostExecutionThread

}
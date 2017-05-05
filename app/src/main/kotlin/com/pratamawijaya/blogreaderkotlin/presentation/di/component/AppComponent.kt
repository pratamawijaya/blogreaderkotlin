package com.pratamawijaya.blogreaderkotlin.presentation.di.component

import android.app.Application
import android.content.Context
import com.pratamawijaya.blogreaderkotlin.BaseApp
import com.pratamawijaya.blogreaderkotlin.data.feature.post.PostServices
import com.pratamawijaya.blogreaderkotlin.data.model.mapper.PostModelMapper
import com.pratamawijaya.blogreaderkotlin.domain.executor.PostExecutionThread
import com.pratamawijaya.blogreaderkotlin.domain.executor.ThreadExecutor
import com.pratamawijaya.blogreaderkotlin.presentation.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by pratama
 * Date : May - 5/5/17
 * Project Name : BlogReaderKotlin
 */

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
  fun inject(application: Application)

  val androidApp: BaseApp

  fun context(): Context

  fun threadExecutor(): ThreadExecutor

  fun postExecutionThread(): PostExecutionThread

  fun postServices(): PostServices

  fun postModelMapper(): PostModelMapper

}
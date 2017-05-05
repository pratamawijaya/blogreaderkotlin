package com.pratamawijaya.blogreaderkotlin.app.di

import android.app.Application
import com.pratamawijaya.blogreaderkotlin.domain.executor.PostExecutionThread
import com.pratamawijaya.blogreaderkotlin.domain.executor.ThreadExecutor

/**
 * Created by pratama
 * Date : May - 5/3/17
 * Project Name : BlogReaderKotlin
 */
interface AppDependencies : ServicesDependencies {

  fun application(): Application

  fun threadExecutor(): ThreadExecutor

  fun postExecutionThread(): PostExecutionThread
}
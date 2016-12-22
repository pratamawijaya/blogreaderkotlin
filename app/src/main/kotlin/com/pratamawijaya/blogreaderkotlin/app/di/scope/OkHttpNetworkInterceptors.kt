package com.pratamawijaya.blogreaderkotlin.app.di.scope

import javax.inject.Qualifier
import javax.inject.Scope

/**
 * Created by mnemonix
 * Date : Dec - 12/22/16
 * Project Name : BlogReaderKotlin
 */
@Scope
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class OkHttpNetworkInterceptors

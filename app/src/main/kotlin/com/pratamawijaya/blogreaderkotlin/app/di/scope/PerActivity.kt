package com.pratamawijaya.blogreaderkotlin.app.di.scope

import javax.inject.Qualifier
import javax.inject.Scope
import kotlin.annotation.AnnotationRetention.RUNTIME

/**
 * Created by pratama
 * Date : May - 5/2/17
 * Project Name : BlogReaderKotlin
 */

@Scope
@Qualifier
@Retention(RUNTIME)
annotation class PerActivity
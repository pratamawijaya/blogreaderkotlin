package com.pratamawijaya.blogreaderkotlin.presentation.ui.home.di

import com.pratamawijaya.blogreaderkotlin.presentation.di.component.AppComponent
import com.pratamawijaya.blogreaderkotlin.presentation.di.scope.ActivityScope
import com.pratamawijaya.blogreaderkotlin.presentation.ui.home.MainActivity
import dagger.Component

/**
 * Created by mnemonix
 * Date : Dec - 12/22/16
 * Project Name : BlogReaderKotlin
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(MainModule::class))
interface MainComponent {
  fun inject(activity: MainActivity)
}
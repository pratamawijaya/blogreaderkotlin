package com.pratamawijaya.blogreaderkotlin.presentation.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pratamawijaya.blogreaderkotlin.app.di.component.AppComponent
import com.pratamawijaya.blogreaderkotlin.app.BaseApp

/**
 * Created by mnemonix
 * Date : Dec - 12/22/16
 * Project Name : BlogReaderKotlin
 */
abstract class BaseActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setupActivityComponent()
  }

  private fun setupActivityComponent() {
    buildComponent(BaseApp.get(this).appComponent)
  }

  abstract fun buildComponent(appComponent: AppComponent)
}
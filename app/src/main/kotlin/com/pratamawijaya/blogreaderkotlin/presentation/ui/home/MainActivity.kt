package com.pratamawijaya.blogreaderkotlin.presentation.ui.home

import android.os.Bundle
import android.widget.Toast
import com.pratamawijaya.blogreaderkotlin.R.layout
import com.pratamawijaya.blogreaderkotlin.app.di.AppComponent
import com.pratamawijaya.blogreaderkotlin.presentation.base.BaseActivity
import com.pratamawijaya.blogreaderkotlin.presentation.ui.home.di.DaggerMainComponent
import com.pratamawijaya.blogreaderkotlin.presentation.ui.home.di.MainModule
import kotlinx.android.synthetic.main.activity_main.btnHello
import timber.log.Timber

class MainActivity : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)

    Timber.d("debug")

    btnHello.setOnClickListener(
        { Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show() })
  }

  override fun buildComponent(appComponent: AppComponent) {
    DaggerMainComponent.builder()
        .appComponent(appComponent)
        .mainModule(MainModule(this))
        .build();
  }
}

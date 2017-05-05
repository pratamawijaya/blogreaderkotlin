package com.pratamawijaya.blogreaderkotlin.presentation.ui.home

import android.os.Bundle
import com.pratamawijaya.blogreaderkotlin.R.layout
import com.pratamawijaya.blogreaderkotlin.app.di.component.AppComponent
import com.pratamawijaya.blogreaderkotlin.domain.entity.Post
import com.pratamawijaya.blogreaderkotlin.presentation.base.BaseActivity

class MainActivity : BaseActivity(), MainView {


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)

  }

  override fun buildComponent(appComponent: AppComponent) {

  }

  override fun showLoading() {
  }

  override fun hideLoading() {
  }

  override fun showMessage(message: String?) {
  }


  override fun displayData(t: List<Post>) {

  }

}

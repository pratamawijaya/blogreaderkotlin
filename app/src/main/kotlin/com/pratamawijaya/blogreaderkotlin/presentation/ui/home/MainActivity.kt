package com.pratamawijaya.blogreaderkotlin.presentation.ui.home

import android.os.Bundle
import android.widget.Toast
import com.pratamawijaya.blogreaderkotlin.R.layout
import com.pratamawijaya.blogreaderkotlin.domain.entity.Post
import com.pratamawijaya.blogreaderkotlin.presentation.base.BaseActivity
import com.pratamawijaya.blogreaderkotlin.presentation.di.component.AppComponent
import com.pratamawijaya.blogreaderkotlin.presentation.ui.home.di.DaggerMainComponent
import com.pratamawijaya.blogreaderkotlin.presentation.ui.home.di.MainModule
import com.pratamawijaya.blogreaderkotlin.presentation.ui.home.presenter.MainPresenter
import timber.log.Timber
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

  @Inject
  lateinit var presenter: MainPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)

    presenter.attachView(this)
    presenter.getListPost(1, true)
  }

  override fun buildComponent(appComponent: AppComponent) {
    DaggerMainComponent.builder()
        .appComponent(appComponent)
        .mainModule(MainModule(this))
        .build().inject(this)
  }

  override fun showLoading() {
  }

  override fun hideLoading() {
  }

  override fun showMessage(message: String?) {
  }


  override fun displayData(t: List<Post>) {
    for (post in t) {
      Timber.d("title %s", post.title)
      Toast.makeText(this, "title " + post.title, Toast.LENGTH_SHORT)
    }
  }

}

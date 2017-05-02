package com.pratamawijaya.blogreaderkotlin.presentation.ui.home

import android.os.Bundle
import android.widget.Toast
import com.pratamawijaya.blogreaderkotlin.R.layout
import com.pratamawijaya.blogreaderkotlin.app.di.AppComponent
import com.pratamawijaya.blogreaderkotlin.domain.entity.Post
import com.pratamawijaya.blogreaderkotlin.presentation.base.BaseActivity
import com.pratamawijaya.blogreaderkotlin.presentation.ui.home.di.DaggerMainComponent
import com.pratamawijaya.blogreaderkotlin.presentation.ui.home.di.MainModule
import com.pratamawijaya.blogreaderkotlin.presentation.ui.home.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.btnHello
import timber.log.Timber
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

  @Inject
  lateinit var presenter: MainPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)

    Timber.d("debug")

    btnHello.setOnClickListener(
        { Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show() })

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

  }

}

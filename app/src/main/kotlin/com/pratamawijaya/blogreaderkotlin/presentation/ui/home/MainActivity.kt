package com.pratamawijaya.blogreaderkotlin.presentation.ui.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import com.pratamawijaya.blogreaderkotlin.R.layout
import com.pratamawijaya.blogreaderkotlin.domain.entity.Post
import com.pratamawijaya.blogreaderkotlin.presentation.base.BaseActivity
import com.pratamawijaya.blogreaderkotlin.presentation.di.component.AppComponent
import com.pratamawijaya.blogreaderkotlin.presentation.ui.home.adapter.MainAdapter
import com.pratamawijaya.blogreaderkotlin.presentation.ui.home.di.DaggerMainComponent
import com.pratamawijaya.blogreaderkotlin.presentation.ui.home.di.MainModule
import com.pratamawijaya.blogreaderkotlin.presentation.ui.home.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.loading
import kotlinx.android.synthetic.main.activity_main.rvContent
import timber.log.Timber
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

  @Inject
  lateinit var presenter: MainPresenter

  var posts = arrayListOf<Post>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)

    presenter.attachView(this)
    setupRecyclerView()
    presenter.getListPost(1, true)
  }

  private fun setupRecyclerView() {
    rvContent.layoutManager = LinearLayoutManager(this)
    rvContent.adapter = MainAdapter(this, posts) {
      clickPost(it)
    }
  }

  private fun clickPost(post: Post) {
    Toast.makeText(this, "title " + post.title, Toast.LENGTH_SHORT)
  }

  override fun buildComponent(appComponent: AppComponent) {
    DaggerMainComponent.builder()
        .appComponent(appComponent)
        .mainModule(MainModule(this))
        .build().inject(this)
  }

  override fun showLoading() {
    rvContent.visibility = GONE
    loading.visibility = VISIBLE
  }

  override fun hideLoading() {
    rvContent.visibility = VISIBLE
    loading.visibility = GONE
  }

  override fun showMessage(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
  }


  override fun displayData(t: List<Post>) {
    for (post in t) {
      Timber.d("title %s", post.title)
      posts.add(post)
    }
    rvContent.adapter.notifyDataSetChanged()
  }

}

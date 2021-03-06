package com.pratamawijaya.blogreaderkotlin.presentation.ui.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import com.pratamawijaya.blogreaderkotlin.R.layout
import com.pratamawijaya.blogreaderkotlin.domain.entity.Post
import com.pratamawijaya.blogreaderkotlin.extensions.toast
import com.pratamawijaya.blogreaderkotlin.presentation.base.BaseActivity
import com.pratamawijaya.blogreaderkotlin.presentation.common.InfiniteScrollListener
import com.pratamawijaya.blogreaderkotlin.presentation.di.component.AppComponent
import com.pratamawijaya.blogreaderkotlin.presentation.ui.home.adapter.MainAdapter
import com.pratamawijaya.blogreaderkotlin.presentation.ui.home.di.DaggerMainComponent
import com.pratamawijaya.blogreaderkotlin.presentation.ui.home.di.MainModule
import com.pratamawijaya.blogreaderkotlin.presentation.ui.home.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView, MainAdapter.MainAdapterListener {
    var page: Int = 1

    @Inject
    lateinit var presenter: MainPresenter

    var posts = arrayListOf<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        presenter.attachView(this)
        setupRecyclerView()

        requestPost(page)
    }

    private fun setupRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this)
        rvContent.layoutManager = linearLayoutManager


        rvContent.adapter = MainAdapter(this, posts, this)

        rvContent.addOnScrollListener(InfiniteScrollListener({
            page++
            requestPost(page)
        }, linearLayoutManager))
    }

    private fun requestPost(page: Int) {
        presenter.getListPost(page, true)
    }

    override fun postSelected(post: Post) {
        Log.d("mainactivity", "data : ${post.title}")
        toast(post.title ?: "empty")
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

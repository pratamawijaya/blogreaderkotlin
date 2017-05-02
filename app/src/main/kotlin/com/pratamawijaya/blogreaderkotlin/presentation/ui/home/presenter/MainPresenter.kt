package com.pratamawijaya.blogreaderkotlin.presentation.ui.home.presenter

import com.pratamawijaya.blogreaderkotlin.domain.usecase.post.GetBlogPosts
import com.pratamawijaya.blogreaderkotlin.presentation.base.BasePresenter
import com.pratamawijaya.blogreaderkotlin.presentation.ui.home.MainView
import rx.subscriptions.CompositeSubscription
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by mnemonix
 * Date : Dec - 12/23/16
 * Project Name : BlogReaderKotlin
 */
class MainPresenter @Inject constructor(
    private val getBlogPosts: GetBlogPosts) : BasePresenter<MainView>() {

  private var compositeSub = CompositeSubscription()

  override fun attachView(mvpView: MainView) {
    super.attachView(mvpView)
    compositeSub = CompositeSubscription()
  }

  override fun detachView() {
    super.detachView()
    compositeSub.unsubscribe()
  }

  fun getListPost(page: Int, isUpdate: Boolean) {
    Timber.d("page %s %s", page, isUpdate)
    getView().showLoading()
    getBlogPosts.page = page
    getBlogPosts.isUpdate = isUpdate


//    getBlogPosts.buildUseCaseObservable()
//        .subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribe(
//            FunctionSubscriber<List<Post>>().onNext {
//              getView().hideLoading()
//              getView().setData(it)
//            }.onError {
//              getView().showMessage(it.message)
//            }.onCompleted {
//              getView().hideLoading()
//            })
  }

}
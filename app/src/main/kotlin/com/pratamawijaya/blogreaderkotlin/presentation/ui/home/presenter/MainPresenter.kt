package com.pratamawijaya.blogreaderkotlin.presentation.ui.home.presenter

import com.pratamawijaya.blogreaderkotlin.presentation.base.BasePresenter
import com.pratamawijaya.blogreaderkotlin.presentation.ui.home.MainView

/**
 * Created by mnemonix
 * Date : Dec - 12/23/16
 * Project Name : BlogReaderKotlin
 */
class MainPresenter : BasePresenter<MainView>() {

//  override fun attachView(mvpView: MainView) {
//    super.attachView(mvpView)
//  }
//
//  override fun detachView() {
//    super.detachView()
//    getListPost.dispose()
//  }
//
//  fun getListPost(page: Int, isUpdate: Boolean) {
//    Timber.d("page %s isupdate %s", page, isUpdate)
//    getView().showLoading()
//    getListPost.execute(ListPostObserver(), GetListPost.Params.forPost(page, isUpdate))
//  }
//
//  inner class ListPostObserver : DefaultObserver<List<Post>>() {
//    override fun onNext(t: List<Post>) {
//      super.onNext(t)
//      this@MainPresenter.getView().displayData(t)
//    }
//
//    override fun onError(e: Throwable?) {
//      super.onError(e)
//      Timber.e(e?.localizedMessage)
//      this@MainPresenter.getView().showMessage(e?.localizedMessage)
//    }
//
//    override fun onComplete() {
//      super.onComplete()
//      this@MainPresenter.getView().hideLoading()
//    }
//  }

}
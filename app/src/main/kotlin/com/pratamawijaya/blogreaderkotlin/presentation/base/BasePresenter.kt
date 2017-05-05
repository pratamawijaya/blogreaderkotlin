package com.pratamawijaya.blogreaderkotlin.presentation.base

/**
 * Created by mnemonix
 * Date : Dec - 12/23/16
 * Project Name : BlogReaderKotlin
 */
open class BasePresenter<T : BaseView> : Presenter<T> {

  private var view: T? = null

  override fun attachView(mvpView: T) {
    this.view = mvpView
  }

  override fun detachView() {
    this.view = null
  }

  fun isViewAttached(): Boolean {
    return view != null
  }

  fun getView(): T = view!!

  fun checkViewAttached() {
    if (!isViewAttached()) throw MvpViewNotAttachedException()
  }

  class MvpViewNotAttachedException : RuntimeException(
      "Please call Presenter.attachView(MvpView) before" + " requesting data to the Presenter")

}
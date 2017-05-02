package com.pratamawijaya.blogreaderkotlin.domain.usecase

import io.reactivex.observers.DisposableObserver

/**
 * Created by pratama
 * Date : May - 5/2/17
 * Project Name : BlogReaderKotlin
 */
open class DefaultObserver<T> : DisposableObserver<T>() {
  override fun onNext(t: T) {
  }

  override fun onError(e: Throwable?) {
  }

  override fun onComplete() {
  }
}
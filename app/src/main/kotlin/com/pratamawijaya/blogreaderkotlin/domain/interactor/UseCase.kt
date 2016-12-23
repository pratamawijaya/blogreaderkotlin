package com.pratamawijaya.blogreaderkotlin.domain.interactor

import rx.Observable

/**
 * Created by mnemonix
 * Date : Dec - 12/23/16
 * Project Name : BlogReaderKotlin
 */
abstract class UseCase<T> {
  /**
   * Builds an [Observable] which will be used when executing the current [UseCase].
   */
  open abstract fun buildUseCaseObservable(): Observable<T>
}
package com.pratamawijaya.blogreaderkotlin.presentation.base

/**
 * Created by mnemonix
 * Date : Dec - 12/23/16
 * Project Name : BlogReaderKotlin
 */
interface Presenter<V : BaseView> {
    fun attachView(mvpView: V)

    fun detachView()
}
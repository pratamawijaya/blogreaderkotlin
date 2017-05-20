package com.pratamawijaya.blogreaderkotlin.presentation.base

/**
 * Created by mnemonix
 * Date : Dec - 12/23/16
 * Project Name : BlogReaderKotlin
 */
interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun showMessage(message: String?)
}
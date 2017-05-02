package com.pratamawijaya.blogreaderkotlin.presentation.ui.home

import com.pratamawijaya.blogreaderkotlin.domain.entity.Post
import com.pratamawijaya.blogreaderkotlin.presentation.base.BaseView

/**
 * Created by mnemonix
 * Date : Dec - 12/23/16
 * Project Name : BlogReaderKotlin
 */
interface MainView : BaseView {

  fun displayData(t: List<Post>)

}
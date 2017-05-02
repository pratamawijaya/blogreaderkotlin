package com.pratamawijaya.blogreaderkotlin.domain.entity

import java.util.Date

/**
 * Created by mnemonix
 * Date : Dec - 12/23/16
 * Project Name : BlogReaderKotlin
 */
open class Post {
  var id: Int = 0
  var title: String? = null
  var url: String? = null
  var date: Date? = null
  var content: String? = null

}
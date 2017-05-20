package com.pratamawijaya.blogreaderkotlin.domain.entity

import com.pratamawijaya.blogreaderkotlin.presentation.utils.DateFormatter
import java.util.*

/**
 * Created by mnemonix
 * Date : Dec - 12/23/16
 * Project Name : BlogReaderKotlin
 */
open class Post {
    var id: Int = 0
    var title: String? = null
    var url: String? = null
    var date: Date = Date()
    var content: String? = null

    fun getDateFormatted(): String = DateFormatter.formatDate(date, DateFormatter.FORMAT_DAY)
}
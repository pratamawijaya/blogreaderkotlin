package com.pratamawijaya.blogreaderkotlin.domain.entity

import java.util.Date

/**
 * Created by mnemonix
 * Date : Dec - 12/23/16
 * Project Name : BlogReaderKotlin
 */
open class Post(id: Int = 0, title: String = "", url: String = "", date: Date? = null,
    content: String = "", modified: Date?)
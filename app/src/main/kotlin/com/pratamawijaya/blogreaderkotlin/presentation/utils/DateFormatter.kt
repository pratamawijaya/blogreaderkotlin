package com.pratamawijaya.blogreaderkotlin.presentation.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by pratama
 * Date : May - 5/20/17
 * Project Name : BlogReaderKotlin
 */

class DateFormatter {
    companion object {
        val FORMAT_DAY = "EEE, d MMM yyyy"
        val FORMAT_SERVER = "yyyy-MM-dd"

        fun formatDate(date: Date, format: String): String {
            val dateFormatter = SimpleDateFormat(format, Locale.getDefault())
            return dateFormatter.format(date)
        }
    }
}
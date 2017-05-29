package com.pratamawijaya.blogreaderkotlin.extensions

import android.app.Activity
import android.widget.Toast

/**
 * Created by pratama
 * Date : May - 5/29/17
 * Project Name : BlogReaderKotlin
 */

/**
 * show toast
 */
fun Activity.toast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}
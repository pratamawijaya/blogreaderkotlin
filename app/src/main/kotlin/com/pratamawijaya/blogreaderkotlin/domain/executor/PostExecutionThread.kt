package com.pratamawijaya.blogreaderkotlin.domain.executor

import io.reactivex.Scheduler

/**
 * Created by mnemonix
 * Date : Dec - 12/22/16
 * Project Name : BlogReaderKotlin
 */
interface PostExecutionThread {
    fun getScheduler(): Scheduler
}
package com.pratamawijaya.blogreaderkotlin.domain.executor

import rx.Scheduler

/**
 * Created by mnemonix
 * Date : Dec - 12/22/16
 * Project Name : BlogReaderKotlin
 */
interface PostExecutionThread {
  val scheduler: Scheduler
}
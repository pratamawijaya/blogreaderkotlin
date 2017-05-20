package com.pratamawijaya.blogreaderkotlin.domain.usecase.post

import com.pratamawijaya.blogreaderkotlin.domain.entity.Post
import com.pratamawijaya.blogreaderkotlin.domain.executor.PostExecutionThread
import com.pratamawijaya.blogreaderkotlin.domain.executor.ThreadExecutor
import com.pratamawijaya.blogreaderkotlin.domain.repository.PostRepository
import com.pratamawijaya.blogreaderkotlin.domain.usecase.UseCase
import javax.inject.Inject

/**
 * Created by mnemonix
 * Date : Dec - 12/23/16
 * Project Name : BlogReaderKotlin
 */
open class GetListPost @Inject constructor(threadExecutor: ThreadExecutor,
                                           postExecutionThread: PostExecutionThread,
                                           private val repository: PostRepository) : UseCase<List<Post>, GetListPost.Params>(
        threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: Params): io.reactivex.Observable<List<Post>> {
        return repository.getPosts(params.page, params.isUpdate)
    }

    class Params private constructor(val page: Int, val isUpdate: Boolean) {
        companion object {
            fun forPost(page: Int, isUpdate: Boolean): Params {
                return Params(page, isUpdate)
            }
        }
    }

}
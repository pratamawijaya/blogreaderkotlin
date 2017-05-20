package com.pratamawijaya.blogreaderkotlin.domain.usecase.post

import com.pratamawijaya.blogreaderkotlin.domain.entity.Post
import com.pratamawijaya.blogreaderkotlin.domain.executor.PostExecutionThread
import com.pratamawijaya.blogreaderkotlin.domain.executor.ThreadExecutor
import com.pratamawijaya.blogreaderkotlin.domain.repository.PostRepository
import com.pratamawijaya.blogreaderkotlin.domain.usecase.UseCase
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by mnemonix
 * Date : Dec - 12/23/16
 * Project Name : BlogReaderKotlin
 */
class GetSinglePost @Inject constructor(threadExecutor: ThreadExecutor,
                                        postExecutionThread: PostExecutionThread,
                                        private val repository: PostRepository) : UseCase<Post, GetSinglePost.Params>(
        threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: Params): Observable<Post> {
        return repository.getPost(params.postId, params.isUpdate)
    }

    class Params private constructor(val postId: Int, val isUpdate: Boolean) {
        companion object {
            fun forPost(postId: Int, isUpdate: Boolean): Params {
                return Params(postId, isUpdate)
            }
        }
    }

}
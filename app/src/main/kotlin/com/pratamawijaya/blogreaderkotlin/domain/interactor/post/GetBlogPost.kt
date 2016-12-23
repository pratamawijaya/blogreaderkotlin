package com.pratamawijaya.blogreaderkotlin.domain.interactor.post

import com.pratamawijaya.blogreaderkotlin.domain.entity.Post
import com.pratamawijaya.blogreaderkotlin.domain.interactor.UseCase
import com.pratamawijaya.blogreaderkotlin.domain.repository.PostRepository
import rx.Observable
import javax.inject.Inject

/**
 * Created by mnemonix
 * Date : Dec - 12/23/16
 * Project Name : BlogReaderKotlin
 */
class GetBlogPost @Inject constructor(private val repository: PostRepository) : UseCase<Post>() {


  var isUpdate: Boolean = false
  var postId: Int = 0

  override fun buildUseCaseObservable(): Observable<Post> {
    return repository.getPost(postId, isUpdate)
  }

}
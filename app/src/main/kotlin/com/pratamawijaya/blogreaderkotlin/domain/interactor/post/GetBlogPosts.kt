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
class GetBlogPosts @Inject constructor(private val repository: PostRepository) : UseCase<List<Post>>() {

  var page: Int = 0
  var isUpdate: Boolean = false

  override fun buildUseCaseObservable(): Observable<List<Post>> {
    return repository.getPosts(page, isUpdate)
  }

}
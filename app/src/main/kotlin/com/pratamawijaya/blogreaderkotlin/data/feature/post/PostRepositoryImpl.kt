package com.pratamawijaya.blogreaderkotlin.data.feature.post

import com.pratamawijaya.blogreaderkotlin.data.model.mapper.PostModelMapper
import com.pratamawijaya.blogreaderkotlin.domain.entity.Post
import com.pratamawijaya.blogreaderkotlin.domain.repository.PostRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by mnemonix
 * Date : Dec - 12/23/16
 * Project Name : BlogReaderKotlin
 */
class PostRepositoryImpl @Inject constructor(val postServices: PostServices,
    val postMapper: PostModelMapper) : PostRepository {

  override fun getPosts(page: Int, isUpdate: Boolean): Observable<List<Post>> {
    throw UnsupportedOperationException(
        "not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun getPost(postId: Int, isUpdate: Boolean): Observable<Post> {
    throw UnsupportedOperationException(
        "not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}
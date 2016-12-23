package com.pratamawijaya.blogreaderkotlin.domain.repository

import com.pratamawijaya.blogreaderkotlin.domain.entity.Post
import rx.Observable

/**
 * Created by mnemonix
 * Date : Dec - 12/23/16
 * Project Name : BlogReaderKotlin
 */
interface PostRepository {
  fun getPosts(page: Int, isUpdate: Boolean): Observable<List<Post>>

  fun getPost(postId: Int, isUpdate: Boolean): Observable<Post>
}
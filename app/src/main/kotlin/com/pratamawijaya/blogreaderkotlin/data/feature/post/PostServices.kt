package com.pratamawijaya.blogreaderkotlin.data.feature.post

import com.pratamawijaya.blogreaderkotlin.data.model.PostResponse
import com.pratamawijaya.blogreaderkotlin.data.model.PostsResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by pratama
 * Date : May - 5/2/17
 * Project Name : BlogReaderKotlin
 */
interface PostServices {
  @GET("get_recent_posts/") fun getRecentPosts(@Query("page") page: Int): Observable<PostsResponse>

  @GET("get_post/") fun getPost(@Query("post_id") postId: Int): Observable<PostResponse>
}

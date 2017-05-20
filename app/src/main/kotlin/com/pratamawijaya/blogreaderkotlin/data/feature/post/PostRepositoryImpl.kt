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
class PostRepositoryImpl @Inject constructor(val services: PostServices,
                                             val postMapper: PostModelMapper) : PostRepository {

    override fun getPosts(page: Int, isUpdate: Boolean): Observable<List<Post>> {
        return services.getRecentPosts(page)
                .flatMap { Observable.just(it.posts) }
                .map { this.postMapper.transform(it) }
    }

    override fun getPost(postId: Int, isUpdate: Boolean): Observable<Post> {
        return services.getPost(postId)
                .flatMap { Observable.just(it.post) }
                .map { this.postMapper.transform(it) }
    }
}
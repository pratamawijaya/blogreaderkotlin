package com.pratamawijaya.blogreaderkotlin.data.model.mapper

import com.pratamawijaya.blogreaderkotlin.data.model.PostModel
import com.pratamawijaya.blogreaderkotlin.domain.entity.Post

/**
 * Created by pratama
 * Date : May - 5/2/17
 * Project Name : BlogReaderKotlin
 */

class PostModelMapper {

  fun transform(collection: List<PostModel>): List<Post> {
    val list = ArrayList<Post>()
    var entity: Post?

    for (model in collection) {
      entity = transform(model)
      if (entity != null) {
        list.add(entity)
      }
    }
    return list
  }

  fun transform(model: PostModel?): Post? {
    if (model != null) {
      val post = Post()
      post.id = model.id
      post.title = model.title
      post.url = model.url
      post.content = model.content
      return post
    }
    return null
  }
}
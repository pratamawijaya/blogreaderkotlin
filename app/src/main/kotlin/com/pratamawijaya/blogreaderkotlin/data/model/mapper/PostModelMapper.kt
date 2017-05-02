package com.pratamawijaya.blogreaderkotlin.data.model.mapper

import com.pratamawijaya.blogreaderkotlin.data.model.PostModel
import com.pratamawijaya.blogreaderkotlin.domain.entity.Post

/**
 * Created by pratama
 * Date : May - 5/2/17
 * Project Name : BlogReaderKotlin
 */
class PostModelMapper {
  companion object {
    fun map(form: PostModel): Post {
      return Post()
    }
  }
}
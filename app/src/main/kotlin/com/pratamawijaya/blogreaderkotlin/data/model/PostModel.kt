package com.pratamawijaya.blogreaderkotlin.data.model

import java.util.Date

/**
 * Created by pratama
 * Date : May - 5/2/17
 * Project Name : BlogReaderKotlin
 */
data class PostModel(val id: Int,
                     val type: String,
                     val slug: String,
                     val title: String,
                     val url: String,
                     val content: String,
                     val excerpt: String,
                     val date: Date,
                     val modified: Date
)

data class PostResponse(val post: PostModel)

data class PostsResponse(val posts: List<PostModel>)

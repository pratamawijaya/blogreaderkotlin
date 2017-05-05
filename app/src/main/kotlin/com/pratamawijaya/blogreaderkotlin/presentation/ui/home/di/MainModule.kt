package com.pratamawijaya.blogreaderkotlin.presentation.ui.home.di

import android.app.Activity
import com.pratamawijaya.blogreaderkotlin.data.feature.post.PostRepositoryImpl
import com.pratamawijaya.blogreaderkotlin.domain.entity.Post
import com.pratamawijaya.blogreaderkotlin.domain.repository.PostRepository
import com.pratamawijaya.blogreaderkotlin.domain.usecase.UseCase
import com.pratamawijaya.blogreaderkotlin.domain.usecase.post.GetListPost
import com.pratamawijaya.blogreaderkotlin.domain.usecase.post.GetListPost.Params
import dagger.Module
import dagger.Provides

/**
 * Created by mnemonix
 * Date : Dec - 12/22/16
 * Project Name : BlogReaderKotlin
 */

@Module
class MainModule constructor(var activity: Activity) {

  @Provides fun provideActivity(): Activity {
    return activity
  }

  @Provides fun provideRepository(postRepositoryImpl: PostRepositoryImpl): PostRepository {
    return postRepositoryImpl
  }

  @Provides fun provideGetPostUseCase(
      getListPost: GetListPost): UseCase<List<Post>, Params> {
    return getListPost
  }
}
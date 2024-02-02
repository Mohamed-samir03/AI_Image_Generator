package com.mosamir.aiimagegenerator.features.image_generator.di

import com.mosamir.aiimagegenerator.features.image_generator.data.data_source.remote.IImageDataSource
import com.mosamir.aiimagegenerator.features.image_generator.data.repository.ImageRepo
import com.mosamir.aiimagegenerator.features.image_generator.domain.repository.IImageRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Provides
    fun provideAuthRepo(iImageDataSource: IImageDataSource):IImageRepo
            = ImageRepo(iImageDataSource)


}
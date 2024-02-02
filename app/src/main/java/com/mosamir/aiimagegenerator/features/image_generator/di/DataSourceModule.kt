package com.mosamir.aiimagegenerator.features.image_generator.di

import com.mosamir.aiimagegenerator.features.image_generator.data.data_source.remote.IImageDataSource
import com.mosamir.aiimagegenerator.features.image_generator.data.data_source.remote.ImageApiService
import com.mosamir.aiimagegenerator.features.image_generator.data.data_source.remote.ImageDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {


    @Provides
    fun provideImageDataSource(apiService: ImageApiService):IImageDataSource = ImageDataSource(apiService)


}
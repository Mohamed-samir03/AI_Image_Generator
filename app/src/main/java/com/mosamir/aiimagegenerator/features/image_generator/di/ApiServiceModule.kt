package com.mosamir.aiimagegenerator.features.image_generator.di

import com.mosamir.aiimagegenerator.features.image_generator.data.data_source.remote.ImageApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
object ApiServiceModule {


    @Provides
    fun provideImageAPIService(retrofit: Retrofit):ImageApiService
            = retrofit.create(ImageApiService::class.java)


}
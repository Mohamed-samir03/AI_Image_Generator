package com.mosamir.atmodrivepassenger.features.auth.di

import com.mosamir.aiimagegenerator.features.image_generator.domain.repository.IImageRepo
import com.mosamir.aiimagegenerator.features.image_generator.domain.use_case.GenerateImageUseCase
import com.mosamir.aiimagegenerator.features.image_generator.domain.use_case.IGenerateImageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UdeCaseModule {


    @Provides
    fun provideGenerateImageUseCase(iImageRepo: IImageRepo):IGenerateImageUseCase = GenerateImageUseCase(iImageRepo)


}
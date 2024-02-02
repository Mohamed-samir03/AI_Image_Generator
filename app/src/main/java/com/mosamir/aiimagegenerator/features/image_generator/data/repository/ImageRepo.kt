package com.mosamir.aiimagegenerator.features.image_generator.data.repository

import com.mosamir.aiimagegenerator.features.image_generator.data.data_source.remote.IImageDataSource
import com.mosamir.aiimagegenerator.features.image_generator.domain.model.ImageGenerator
import com.mosamir.aiimagegenerator.features.image_generator.domain.repository.IImageRepo
import com.mosamir.aiimagegenerator.util.IResult
import javax.inject.Inject

class ImageRepo @Inject constructor(
private val iImageDataSource: IImageDataSource
) : IImageRepo {
    override suspend fun generateImage(prompt: String): IResult<ImageGenerator> {
        return iImageDataSource.generateImage(prompt)
    }
}
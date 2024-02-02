package com.mosamir.aiimagegenerator.features.image_generator.data.data_source.remote

import com.mosamir.aiimagegenerator.features.image_generator.domain.model.ImageGenerator
import com.mosamir.aiimagegenerator.util.IResult

interface IImageDataSource {

    suspend fun generateImage(prompt:String):IResult<ImageGenerator>

}
package com.mosamir.aiimagegenerator.features.image_generator.domain.repository

import com.mosamir.aiimagegenerator.features.image_generator.domain.model.ImageGenerator
import com.mosamir.aiimagegenerator.util.IResult

interface IImageRepo {

    suspend fun generateImage(prompt:String): IResult<ImageGenerator>

}
package com.mosamir.aiimagegenerator.features.image_generator.domain.use_case

import com.mosamir.aiimagegenerator.features.image_generator.domain.model.ImageGenerator
import com.mosamir.aiimagegenerator.util.IResult

interface IGenerateImageUseCase {

    suspend fun generateImage(prompt:String): IResult<ImageGenerator>

}
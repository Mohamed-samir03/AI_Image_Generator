package com.mosamir.aiimagegenerator.features.image_generator.domain.use_case

import com.mosamir.aiimagegenerator.features.image_generator.domain.model.ImageGenerator
import com.mosamir.aiimagegenerator.features.image_generator.domain.repository.IImageRepo
import com.mosamir.aiimagegenerator.util.IResult
import javax.inject.Inject

class GenerateImageUseCase @Inject constructor(
    private val iImageRepo: IImageRepo
): IGenerateImageUseCase {
    override suspend fun generateImage(prompt: String): IResult<ImageGenerator> {
        return iImageRepo.generateImage(prompt)
    }
}
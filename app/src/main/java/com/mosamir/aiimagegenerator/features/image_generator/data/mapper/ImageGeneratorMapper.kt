package com.mosamir.aiimagegenerator.features.image_generator.data.mapper

import com.mosamir.aiimagegenerator.features.image_generator.data.model.ImageGeneratorResponse
import com.mosamir.aiimagegenerator.features.image_generator.domain.model.ImageGenerator

fun ImageGeneratorResponse.asDomain() = ImageGenerator(
    data = data
)
package com.mosamir.aiimagegenerator.features.image_generator.data.data_source.remote

import com.mosamir.aiimagegenerator.features.image_generator.data.mapper.asDomain
import com.mosamir.aiimagegenerator.features.image_generator.domain.model.ImageGenerator
import com.mosamir.aiimagegenerator.util.IResult
import com.mosamir.aiimagegenerator.util.NetworkState
import javax.inject.Inject

class ImageDataSource @Inject constructor(
    private val imageApiService: ImageApiService
): IImageDataSource {
    override suspend fun generateImage(prompt: String): IResult<ImageGenerator> {
        return try {
            val response = imageApiService.generateImage(prompt)
            return IResult.onSuccess(response.asDomain())
        }catch (e: Exception){
            IResult.onFail(NetworkState.getErrorMessage(e).msg.toString())
        }
    }
}
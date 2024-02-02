package com.mosamir.aiimagegenerator.features.image_generator.data.data_source.remote

import com.mosamir.aiimagegenerator.features.image_generator.data.model.ImageGeneratorResponse
import com.mosamir.aiimagegenerator.util.Constants.Companion.IMAGE_END_POINT
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ImageApiService {

    @POST(IMAGE_END_POINT)
    @FormUrlEncoded
    suspend fun generateImage(@Field("prompt") prompt:String):ImageGeneratorResponse

}
package com.mosamir.aiimagegenerator.features.image_generator.presentation.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mosamir.aiimagegenerator.features.image_generator.domain.use_case.IGenerateImageUseCase
import com.mosamir.aiimagegenerator.util.NetworkState
import com.mosamir.aiimagegenerator.util.getError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenerateImageViewModel @Inject constructor(
    private val iGenerateImageUseCase: IGenerateImageUseCase
) :ViewModel(){

    private val _generateImage: MutableStateFlow<NetworkState?> = MutableStateFlow(null)
    val generateImage: StateFlow<NetworkState?> = _generateImage


    fun generateImage(prompt: String) {
        _generateImage.value = NetworkState.LOADING
        viewModelScope.launch {
            try {
                val result = iGenerateImageUseCase.generateImage(prompt)
                if (result.isSuccessful()){
                    _generateImage.value = NetworkState.getLoaded(result)
                }else{
                    _generateImage.value = NetworkState.getErrorMessage(result.getError().toString())
                }
            }catch (ex:Exception){
                ex.printStackTrace()
                _generateImage.value = NetworkState.getErrorMessage(ex)
            }
        }
    }

}
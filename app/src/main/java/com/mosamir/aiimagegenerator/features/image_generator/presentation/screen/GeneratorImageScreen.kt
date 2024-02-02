package com.mosamir.aiimagegenerator.features.image_generator.presentation.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.mosamir.aiimagegenerator.R
import com.mosamir.aiimagegenerator.features.image_generator.domain.model.ImageGenerator
import com.mosamir.aiimagegenerator.features.image_generator.presentation.common.GenerateImageViewModel
import com.mosamir.aiimagegenerator.ui.theme.Rubik
import com.mosamir.aiimagegenerator.util.NetworkState
import kotlinx.coroutines.launch

@Composable
fun GeneratorImageScreen(
    viewModel: GenerateImageViewModel
){

    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            viewModel.generateImage("test")
        }
    }

    val state by viewModel.generateImage.collectAsState()

    GeneratorImageContent(state)

}

@Composable
fun GeneratorImageContent(
    state: NetworkState?
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.ai_logo))
    var promptText by rememberSaveable {
        mutableStateOf("")
    }
    var loadingState by rememberSaveable {
        mutableStateOf(false)
    }
    var generatorImage by rememberSaveable {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        when(state?.status){
            NetworkState.Status.SUCCESS -> {
                loadingState = false
                generatorImage = (state.data as ImageGenerator).data[0]
                Log.e("TAG", "GeneratorImageContent: $generatorImage")
            }
            NetworkState.Status.FAILED -> {
                loadingState = false
                Log.e("TAG", "GeneratorImageContent: ${state.msg}")
            }
            NetworkState.Status.RUNNING -> {
                loadingState = true
            }
            else->{}
        }

        Text(
            text ="AI Image Generator🤖",
            color = Color.White,
            fontSize = 18.sp,
            fontFamily = Rubik,
            fontWeight = FontWeight.Medium,
        )

        Box(
            modifier = Modifier.size(300.dp)
        ) {
            if (generatorImage.isNotEmpty()){
                Image(
                    painter = rememberAsyncImagePainter(model = generatorImage),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .height(200.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
            }
            if (loadingState) {
                LottieAnimation(
                    composition = composition,
                    iterations = LottieConstants.IterateForever
                )
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text ="Enter your prompt",
                color = Color.White,
                fontSize = 18.sp,
                fontFamily = Rubik,
                fontWeight = FontWeight.Medium,
            )
            OutlinedTextField(
                value = promptText,
                onValueChange = {newText ->
                    promptText = newText
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 16.dp)
                    .height(52.dp),
                textStyle = TextStyle(
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = Rubik,
                    fontWeight = FontWeight.Normal
                )
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(5.dp),
                onClick = {

                },
            ) {
                Text(
                    text = "Generate",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = Rubik,
                    fontWeight = FontWeight.Medium,
                )
            }
        }

    }

}
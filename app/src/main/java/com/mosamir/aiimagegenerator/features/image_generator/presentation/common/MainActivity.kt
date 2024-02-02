package com.mosamir.aiimagegenerator.features.image_generator.presentation.common

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Scaffold
import com.mosamir.aiimagegenerator.features.image_generator.presentation.screen.GeneratorImageScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel by viewModels<GenerateImageViewModel>()
        setContent {
            Scaffold {
                GeneratorImageScreen(viewModel)
            }
        }
    }
}
package com.example.mynewapplication.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.example.mynewapplication.navigation.SetupNavGraph
import com.example.mynewapplication.ui.theme.MyNewApplicationTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@ExperimentalCoilApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNewApplicationTheme {
                val navController = rememberNavController()
                SetupNavGraph(
                    navController = navController,
                    context = this
                )
            }
        }
    }
}


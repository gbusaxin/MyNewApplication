package com.example.mynewapplication.presentation.screens.splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.mynewapplication.R
import com.example.mynewapplication.navigation.Screens
import com.example.mynewapplication.ui.theme.Purple200
import com.example.mynewapplication.ui.theme.Purple700
import kotlinx.coroutines.delay


@ExperimentalCoilApi
@Composable
fun SplashScreen(
    navController: NavHostController
) {
    var startAnim by remember {
        mutableStateOf(false)
    }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnim) 1f else 0f,
        animationSpec = tween(
            durationMillis = 2300
        )
    )
    LaunchedEffect(key1 = true) {
        startAnim = true
        delay(2500)
        navController.popBackStack()
        navController.navigate(Screens.Welcome.route)
    }
    SplashContent(
        alpha = alphaAnim.value
    )
}

@ExperimentalCoilApi
@Composable
fun SplashContent(
    alpha: Float
) {
    val painter = rememberImagePainter(
        data = "http://95.217.132.144/mynewapp/images/logo_size.png",
        builder = {
            placeholder(R.drawable.ic_loading)
            error(R.drawable.ic_error)
        }
    )
    Box(
        modifier = Modifier
            .background(if (isSystemInDarkTheme()) Purple700 else Purple200)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .alpha(alpha = alpha),
            painter = painter,
            contentDescription = stringResource(R.string.logo_image)
        )
    }
}
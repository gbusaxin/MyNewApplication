package com.example.mynewapplication.presentation.screens.splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.mynewapplication.R
import com.example.mynewapplication.navigation.Screens
import kotlinx.coroutines.delay


@ExperimentalCoilApi
@Composable
fun SplashScreen(
    navController: NavHostController,
    splashViewModel: SplashViewModel = hiltViewModel()
) {
    val onBoardingCompleted by splashViewModel.onBoardingCompleted.collectAsState()

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
        if (onBoardingCompleted) {
            navController.navigate(
                Screens.Home.route
            )
        } else {
            navController.navigate(
                Screens.Welcome.route
            )
        }
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
            .background(if (isSystemInDarkTheme()) Color.Black else Color.LightGray)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .alpha(alpha = alpha),
            painter = painter,
            contentScale = ContentScale.Fit,
            contentDescription = stringResource(R.string.logo_image)
        )
    }
}
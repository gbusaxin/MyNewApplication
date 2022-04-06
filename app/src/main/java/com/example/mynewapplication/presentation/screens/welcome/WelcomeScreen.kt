package com.example.mynewapplication.presentation.screens.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mynewapplication.R
import com.example.mynewapplication.domain.models.OnBoardingPage
import com.example.mynewapplication.navigation.Screens
import com.example.mynewapplication.ui.theme.*
import com.google.accompanist.pager.*

@ExperimentalPagerApi
@Composable
fun WelcomeScreen(
    navController: NavHostController,
    welcomeViewModel: WelcomeViewModel = hiltViewModel()
) {

    val pages = listOf(
        OnBoardingPage.FirstPage,
        OnBoardingPage.SecondPage,
        OnBoardingPage.ThirdPage
    )

    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = if (isSystemInDarkTheme()) Color.Black else Color.White)
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            state = pagerState,
            count = pages.size,
            verticalAlignment = Alignment.Top
        ) {
            PagerScreen(onBoardingPage = pages[it])
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            pagerState = pagerState,
            inactiveColor = if (isSystemInDarkTheme()) LightOrange else DarkOrange,
            activeColor = if (isSystemInDarkTheme()) DarkOrange else LightOrange,
            spacing = PAGGING_INDICATOR_SPACING
        )
        ButtonFinish(
            pagerState = pagerState,
            modifier = Modifier.weight(1f)
        ) {
            navController.popBackStack()
            navController.navigate(Screens.Home.route)
            welcomeViewModel.setOnBoardingState(true)
        }
    }

}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .fillMaxHeight(0.7f)
                .padding(horizontal = SMALL_PADDING),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = stringResource(id = R.string.app_name)
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = onBoardingPage.title,
            color = if (isSystemInDarkTheme()) Color.White else Color.Black,
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = SMALL_PADDING),
            text = onBoardingPage.description,
            color = if (isSystemInDarkTheme()) Color.LightGray else Color.DarkGray,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}

@ExperimentalPagerApi
@Composable
fun ButtonFinish(
    pagerState: PagerState,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier.padding(horizontal = EXTRA_LARGE_PADDING),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == 2
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (isSystemInDarkTheme()) LightOrange else DarkOrange,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Готов")
            }
        }
    }

}
package com.example.mynewapplication.presentation.screens.chrome

import android.app.Activity
import android.content.ComponentName
import android.graphics.Color
import android.net.Uri
import android.util.Log
import androidx.browser.customtabs.CustomTabsClient
import androidx.browser.customtabs.CustomTabsIntent
import androidx.browser.customtabs.CustomTabsServiceConnection
import androidx.browser.customtabs.CustomTabsSession
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun ChromeScreen(
    viewModel: ChromeViewModel = hiltViewModel(),
    navController: NavHostController,
    context: Activity
) {
    val urlResponse by viewModel.linkResponse.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        var mCustomTabsServiceConnection: CustomTabsServiceConnection? = null
        var mClient: CustomTabsClient? = null
        var mCustomTabsSession: CustomTabsSession? = null
        mCustomTabsServiceConnection = object : CustomTabsServiceConnection() {
            override fun onCustomTabsServiceConnected(
                componentName: ComponentName,
                customTabsClient: CustomTabsClient
            ) {
                //Pre-warming
                mClient = customTabsClient
                mClient?.warmup(0L)
                mCustomTabsSession = mClient?.newSession(null)
            }

            override fun onServiceDisconnected(name: ComponentName) {
                navController.popBackStack()
                context.finish()
                mClient = null
            }
        }
        CustomTabsClient.bindCustomTabsService(
            context,
            "com.android.chrome",
            mCustomTabsServiceConnection
        )
        val customTabsIntent = CustomTabsIntent.Builder(mCustomTabsSession)
            .setToolbarColor(Color.WHITE)
            .setShowTitle(true)
            .build()
        Log.d("CHECK_URL_RESP", urlResponse.toString())
        if (urlResponse != null) {
            customTabsIntent.launchUrl(context, Uri.parse(urlResponse))
        }
    }
}
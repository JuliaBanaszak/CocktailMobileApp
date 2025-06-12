package com.example.cocktailmobileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.cocktailmobileapp.services.GeminiService
import com.example.cocktailmobileapp.ui.AiCocktailScreen
import com.example.cocktailmobileapp.ui.MainScreen
import com.example.cocktailmobileapp.ui.SplashScreen
import com.example.cocktailmobileapp.ui.theme.CocktailMobileAppTheme

class MainActivity : ComponentActivity() {
    private var shouldShowSplash by mutableStateOf(true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) {
            shouldShowSplash = savedInstanceState.getBoolean("SHOW_SPLASH", true)
        }

        enableEdgeToEdge()
        setContent {
            var isDarkTheme by remember { mutableStateOf<Boolean>(false) }
            var showAiScreen by remember { mutableStateOf<Boolean>(false) }
            val geminiService = remember { GeminiService() }

            CocktailMobileAppTheme(darkTheme = isDarkTheme) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (showAiScreen) {
                        AiCocktailScreen(
                            onBack = { showAiScreen = false },
                            geminiService = geminiService
                        )
                    } else if (shouldShowSplash) {
                        SplashScreen(onLoadingComplete = { shouldShowSplash = false })
                    } else {
                        MainScreen(
                            isDarkTheme = isDarkTheme,
                            onToggleTheme = { isDarkTheme = !isDarkTheme },
                            onAiButtonClick = { showAiScreen = true }
                        )
                    }
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("SHOW_SPLASH", shouldShowSplash)
    }
}
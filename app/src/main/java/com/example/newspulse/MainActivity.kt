package com.example.newspulse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.example.newspulse.presentation.onboarding.OnboardingScreen
import com.example.newspulse.ui.theme.NewsPulseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()
        WindowCompat.setDecorFitsSystemWindows(window,false)
        setContent {
            NewsPulseTheme {
                Box (modifier = Modifier.background(color = MaterialTheme.colorScheme.background)){
                    OnboardingScreen()
                }

            }
        }
    }
}

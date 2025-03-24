/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter to find the
 * most up to date changes to the libraries and their usages.
 */

package com.byagowi.animatedtextpersianbug.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontVariation
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import androidx.wear.compose.material3.AnimatedText
import androidx.wear.compose.material3.rememberAnimatedTextFontRegistry

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)

        setTheme(android.R.style.Theme_DeviceDefault)

        setContent {
            MaterialTheme {
                Column(
                    Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    val rtlText = "فارسی"
                    val animatedTextFontRegistry = rememberAnimatedTextFontRegistry(
                        startFontVariationSettings = FontVariation.Settings(),
                        endFontVariationSettings = FontVariation.Settings(),
                    )
                    AnimatedText(
                        text = "Actual: $rtlText",
                        fontRegistry = animatedTextFontRegistry,
                        progressFraction = { 0.5f },
                    )
                    Text("Expected: $rtlText")
                }
            }
        }
    }
}

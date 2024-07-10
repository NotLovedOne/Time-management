package com.example.myapplication.composables.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.myapplication.ui.theme.BlueDark
import com.example.myapplication.ui.theme.BlueLight
import com.example.myapplication.ui.theme.PurpleDark
import com.example.myapplication.ui.theme.PurpleLight
import com.example.myapplication.ui.theme.RedDark
import com.google.accompanist.systemuicontroller.rememberSystemUiController


private val DarkColorScheme = darkColorScheme(
    primary = RedDark,
    secondary = BlueDark,
    tertiary = PurpleDark,
)

private val LightColorScheme = lightColorScheme(
    primary = PurpleLight,
    secondary = BlueLight,
    tertiary = PurpleDark
)


@Composable
fun SecondTheme(
    content: @Composable () -> Unit,
    darkTheme: Boolean = isSystemInDarkTheme(),
) {
    val secondThemeColors = if (isSystemInDarkTheme()) {
        DarkColorScheme
    } else {
        LightColorScheme
    }



    val systemUiController = rememberSystemUiController()
    if(darkTheme){
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
        )
    }else{
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
        )
    }

    MaterialTheme(
        colorScheme = secondThemeColors,
        typography = Typography,
        content = content
    )
}
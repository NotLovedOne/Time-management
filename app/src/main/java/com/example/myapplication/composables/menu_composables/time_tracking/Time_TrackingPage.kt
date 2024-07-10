package com.example.myapplication.composables.menu_composables.time_tracking

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TimeTrackingScreen() {
    var timerRunning by remember { mutableStateOf(false) }
    var timerMinutes by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Timer Minutes: $timerMinutes")

        Button(
            onClick = {
                // Handle start button click
                if (!timerRunning) {
                    timerRunning = true
                    // Start the timer or perform any other action
                }
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Start")
        }

        Button(
            onClick = {
                // Handle stop button click
                if (timerRunning) {
                    timerRunning = false
                    // Stop the timer or perform any other action
                }
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Stop")
        }
    }
}

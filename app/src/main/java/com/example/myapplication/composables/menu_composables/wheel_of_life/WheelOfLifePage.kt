package com.example.myapplication.composables.menu_composables.wheel_of_life

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.myapplication.data.LifeAspect

@Composable
fun WheelOfLifePage() {
    var lifeAspects by remember { mutableStateOf(emptyList<LifeAspect>()) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        RadarChart(
            lifeAspects = lifeAspects,
            modifier = Modifier.fillMaxSize().weight(1f)
        )
        AddLifeAspectButton { newAspect ->
            lifeAspects = lifeAspects + newAspect
        }
    }
}



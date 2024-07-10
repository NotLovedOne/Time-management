package com.example.myapplication.composables.menu_composables.wheel_of_life

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.LifeAspect
import com.example.myapplication.ui.theme.Blue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddLifeAspectButton(
    onAddAspect: (LifeAspect) -> Unit,
) {
    var aspectName by remember { mutableStateOf("") }
    var aspectScore by remember { mutableFloatStateOf(0f) }

    Column(
        modifier = Modifier.padding(horizontal = 25.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = aspectName,
            onValueChange = { aspectName = it },
            label = { Text("Aspect Name", color = Color.White) },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.Transparent,
                containerColor = Blue,
                textColor = Color.White
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Slider(
            value = aspectScore,
            onValueChange = { aspectScore = it },
            valueRange = 0f..1f,
            steps = 10,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                onAddAspect(LifeAspect(aspectName, aspectScore))
                aspectName = ""
                aspectScore = 0f
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Aspect")
        }
    }
}

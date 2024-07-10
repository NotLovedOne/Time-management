package com.example.myapplication.composables.menu_composables.budget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun BudgetScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center
    ) {
        PieChart(
            data = mapOf(
                Pair("Food", 150),
                Pair("House", 120),
                Pair("Transport", 110),
                Pair("Vacation", 170),
                Pair("Taxes", 120),
            )
        )

    }
}
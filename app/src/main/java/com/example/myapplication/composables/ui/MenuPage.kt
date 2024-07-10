package com.example.myapplication.composables.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.ui.theme.Bluelovelight
import com.example.myapplication.ui.theme.Greenlovelight
import com.example.myapplication.ui.theme.Pinklovelight
import com.example.myapplication.ui.theme.Purplelovelight
import com.example.myapplication.ui.theme.Redlovelight
import com.example.myapplication.ui.theme.Yellowlovelight

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MenuPage(navController: NavController) {
    val items = listOf(
        MenuItemData(
            R.drawable.weektasks,
            "Weekly Time Keeping",
            "weekly_time_keeping",
            Redlovelight
        ),
        MenuItemData(
            R.drawable.pentagon,
            "Wheel of Life",
            "wheel_of_life",
            Yellowlovelight
        ),
        MenuItemData(
            R.drawable.budgeting,
            "Budget",
            "budget",
            Greenlovelight
        ),
        MenuItemData(
            R.drawable.immunesystem,
            "Health",
            "health",
            Bluelovelight
        ),
        MenuItemData(
            R.drawable.clocktime,
            "Time Tracking",
            "time_tracking",
            Purplelovelight
        ),
        MenuItemData(
            R.drawable.analysis,
            "Report and Analysis",
            "report_and_analysis",
            Pinklovelight
        )
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 12.dp, bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Menu", fontSize = 25.sp, fontWeight = FontWeight.Bold)
            Image(
                painter = painterResource(id = R.drawable.loupe),
                contentDescription = null,
                modifier = Modifier.size(width = 25.dp, height = 25.dp)
            )
        }

        MenuCards(navController, items)

    }
}

@Composable
fun MenuCards(navController: NavController, items: List<MenuItemData>) {
    LazyVerticalGrid (
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
    ) {
        items(items) { item ->
            MenuCard(navController, item)
        }
    }
}

@Composable
fun MenuCard(navController: NavController, item: MenuItemData) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, item.colorBorder, RoundedCornerShape(8.dp))
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(25.dp)
            .height(120.dp)
            .clickable {
                navController.navigate(item.route)
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = item.imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(width = 80.dp, height = 80.dp)
                .padding(bottom = 9.dp)
        )
        Text(
            text = item.title,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            lineHeight = 1.2.em,
        )
    }
}

data class MenuItemData(val imageRes: Int, val title: String, val route: String, val colorBorder: Color)

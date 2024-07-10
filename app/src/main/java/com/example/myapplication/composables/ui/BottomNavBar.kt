package com.example.myapplication.composables.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.data.BottomNavbarItem
import com.example.myapplication.ui.theme.BlueLight

@Composable
fun BottomNavBar(
    navController: NavController,
    items: List<BottomNavbarItem>,
    modifier: Modifier = Modifier
) {
    var selectedNavItem by remember { mutableIntStateOf(0) }

    NavigationBar(
        modifier = modifier.fillMaxWidth()
            .height(height = 60.dp)
            .background(BlueLight),
            containerColor = BlueLight,
    ) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                modifier = Modifier.background(BlueLight),

                selected = index == selectedNavItem,
                onClick = {
                    selectedNavItem = index
                    navController.navigate(item.route)
                },

                icon = { Image(painter = painterResource(id = item.icon),
                                contentDescription = item.label,
                                modifier = Modifier.padding(top = 35.dp, bottom = 8.dp),)},
                label = { Text(text = item.label, fontSize = 12.sp, color = Color.Black) }
            )
        }
    }
}

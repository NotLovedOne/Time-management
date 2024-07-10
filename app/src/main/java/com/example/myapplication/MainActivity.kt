package com.example.myapplication

import MainMenu
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.composables.menu_composables.budget.BudgetScreen
import com.example.myapplication.composables.menu_composables.health.FitnessScreen
import com.example.myapplication.composables.menu_composables.health.HealthsScreen
import com.example.myapplication.composables.menu_composables.health.YogaExerciseList
import com.example.myapplication.composables.menu_composables.weekly_time_keeping.WeeklyTimekeepingScreen
import com.example.myapplication.composables.menu_composables.wheel_of_life.WheelOfLifePage
import com.example.myapplication.composables.ui.BottomNavBar
import com.example.myapplication.composables.ui.LoginPage
import com.example.myapplication.composables.ui.MenuPage
import com.example.myapplication.composables.ui.ProfileMainPage
import com.example.myapplication.composables.ui.ProfilePage
import com.example.myapplication.composables.ui.SettingPage
import com.example.myapplication.composables.ui.addTask.AddTaskPage
import com.example.myapplication.data.BottomNavbarItem
import com.example.myapplication.ui.theme.TESTINGTheme


class MainActivity : ComponentActivity() {
    private val bottomNavItems = listOf(
        BottomNavbarItem("Home", R.drawable.routine, "home"),
        BottomNavbarItem("Menu", R.drawable.menu, "menu"),
        BottomNavbarItem("Profile", R.drawable.user, "profile"),
    )

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        setContent {
            TESTINGTheme {
                Application(bottomNavItems)
            }
        }

    }


}


@SuppressLint("SuspiciousIndentation")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Application( bottomNavItems: List<BottomNavbarItem>) {
    val navController = rememberNavController()
    val routesWithHiddenBottomNav = setOf("helloPage", "login_page", "register_page")
    val navBackStackEntry by navController.currentBackStackEntryAsState()
        Column(
            modifier = Modifier.fillMaxSize().imePadding()
                .background(Color(248,249,251)),
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                NavHost(navController = navController, startDestination = "health", builder = {
                    composable("login_page", content = { LoginPage(navController = navController) })
                    composable("home", content = { MainMenu(navController = navController) })
                    composable("menu", content = { MenuPage(navController = navController) })
                    composable("profile", content = { ProfileMainPage(navController = navController) })
                    composable("profileEdit", content = { ProfilePage(navController = navController) })
                    composable("addTask", content = { AddTaskPage(navController = navController)})
                    composable("setting", content = {SettingPage(navController = navController) })

                    composable(
                        "weekly_time_keeping",
                        content = { WeeklyTimekeepingScreen(navController = navController) })
                    composable("wheel_of_life", content = { WheelOfLifePage() })
                    composable("budget", content = { BudgetScreen() })
                    composable("health", content = { HealthsScreen(navController = navController) })
                    composable("time_tracking", content = { })
                    composable("report_and_analysis", content = { })

                    composable("yoga", content = { YogaExerciseList()})
                    composable("fitness", content = { FitnessScreen() })

                })
            }
            if (navBackStackEntry?.destination?.route !in routesWithHiddenBottomNav) {
                BottomNavBar(
                    navController = navController,
                    items = bottomNavItems,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
}

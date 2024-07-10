package com.example.myapplication.composables.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.ui.theme.BlueBlue

@Composable
fun SettingPage (navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 25.dp, end = 25.dp, top = 10.dp, bottom = 20.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.back),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 20.dp, height = 20.dp)
                    .clickable { navController.popBackStack() }
            )
        }
        Text(
            text = "Settings",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 27.sp,
            )
        )

        Column (modifier = Modifier.padding(top = 40.dp)
            .verticalScroll(rememberScrollState())) {


            Row(modifier = Modifier.padding(bottom = 5.dp)) {
                Icon(
                    imageVector = Icons.Default.Person, contentDescription = "None",
                    modifier = Modifier.padding(end = 11.dp), tint = BlueBlue
                )
                Text(text = "Account", fontWeight = FontWeight.Bold, color = BlueBlue)
            }


            HorizontalLineWithMaxWidth()



            Row(
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 9.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Change password", fontWeight = FontWeight.Bold, color = Color.Gray)
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "None",
                    modifier = Modifier.padding(end = 11.dp), tint = Color.Gray
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 17.dp, bottom = 9.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Content setting", fontWeight = FontWeight.Bold, color = Color.Gray)
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "None",
                    modifier = Modifier.padding(end = 11.dp), tint = Color.Gray
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 17.dp, bottom = 9.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Social", fontWeight = FontWeight.Bold, color = Color.Gray)
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "None",
                    modifier = Modifier.padding(end = 11.dp), tint = Color.Gray
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 17.dp, bottom = 9.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Language", fontWeight = FontWeight.Bold, color = Color.Gray)
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "None",
                    modifier = Modifier.padding(end = 11.dp), tint = Color.Gray
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 17.dp, bottom = 9.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Privacy and security",
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "None",
                    modifier = Modifier.padding(end = 11.dp), tint = Color.Gray
                )
            }


            Row(modifier = Modifier.padding(top = 40.dp, bottom = 9.dp)) {
                Icon(
                    imageVector = Icons.Default.Notifications, contentDescription = "None",
                    modifier = Modifier.padding(end = 11.dp), tint = BlueBlue
                )
                Text(text = "Notification", fontWeight = FontWeight.Bold, color = BlueBlue)
            }

            HorizontalLineWithMaxWidth()


            Row(
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 9.dp, end = 17.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "New for you", fontWeight = FontWeight.Bold, color = Color.Gray)
                SwitchWithIconExample()
            }
            Row(
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 9.dp, end = 17.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Account activity", fontWeight = FontWeight.Bold, color = Color.Gray)
                SwitchWithIconExample()
            }

            Row(
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 9.dp, end = 17.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Opportunity", fontWeight = FontWeight.Bold, color = Color.Gray)
                SwitchWithIconExample()
            }
        }
    }
}

@Composable
fun SwitchWithIconExample() {
    var checked by remember { mutableStateOf(true) }

    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        },
        modifier = Modifier.size(16.dp),
        colors = SwitchDefaults.colors(
            uncheckedTrackColor = Color.White,
        )
    )
}
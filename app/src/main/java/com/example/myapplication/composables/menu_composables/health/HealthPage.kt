package com.example.myapplication.composables.menu_composables.health

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R

@Composable
fun HealthsScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(vertical = 20.dp, horizontal = 15.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        ){
            Row (modifier = Modifier.fillMaxWidth()
                .background(color = Color(192, 241, 241, 255), RoundedCornerShape(10.dp)),
                horizontalArrangement = Arrangement.SpaceBetween)
            {
                Column (modifier = Modifier.fillMaxWidth(0.6f)
                    .padding(start = 20.dp, top = 16.dp, bottom = 16.dp)){
                    Text(text = "Health Tracking", fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(bottom = 15.dp), fontSize = 18.sp)
                    Text(text = "Share your medical indicators, symptoms, and health status", fontSize = 11.sp, lineHeight = 15.sp)
                }
                Image(painter = painterResource(id = R.drawable.doctor),
                    contentDescription = "Doctor",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.padding(top = 10.dp, end = 20.dp))
            }
        }
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(top = 10.dp)
        ){
            Row (modifier = Modifier.fillMaxWidth()
                .background(color = Color(180, 235, 202), RoundedCornerShape(10.dp)),
                horizontalArrangement = Arrangement.SpaceBetween)
            {
                Column (modifier = Modifier.fillMaxWidth(0.6f)
                    .padding(start = 20.dp, top = 16.dp, bottom = 16.dp)){
                    Text(text = "List Of Medications", fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(bottom = 15.dp), fontSize = 18.sp)
                    Text(text = "Easily organize your medications to stay on top of your treatment plan", fontSize = 11.sp, lineHeight = 15.sp)
                }
                Image(painter = painterResource(id = R.drawable.drugs),
                    contentDescription = "Doctor",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.padding(top = 10.dp, end = 20.dp))
            }
        }
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(top = 10.dp)
        ){
            Row (modifier = Modifier.fillMaxWidth()
                .background(color = Color(	217, 242, 180), RoundedCornerShape(10.dp)),
                horizontalArrangement = Arrangement.SpaceBetween)
            {
                Column (modifier = Modifier.fillMaxWidth(0.6f)
                    .padding(start = 20.dp, top = 16.dp, bottom = 16.dp)){
                    Text(text = "Workout", fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(bottom = 15.dp), fontSize = 18.sp)
                    Text(text = "Energize your day with an invigorating workout!", fontSize = 11.sp, lineHeight = 15.sp)
                }
                Image(painter = painterResource(id = R.drawable.workout),
                    contentDescription = "Doctor",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.padding(top = 10.dp, end = 20.dp))
            }
        }
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(top = 10.dp)
        ){
            Row (modifier = Modifier.fillMaxWidth()
                .background(color = Color(	238, 199, 250), RoundedCornerShape(10.dp)),
                horizontalArrangement = Arrangement.SpaceBetween)
            {
                Column (modifier = Modifier.fillMaxWidth(0.6f)
                    .padding(start = 20.dp, top = 16.dp, bottom = 16.dp)){
                    Text(text = "Fitness", fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(bottom = 15.dp), fontSize = 18.sp)
                    Text(text = "Discover the path to a healthier you through the exciting world of fitness!", fontSize = 11.sp, lineHeight = 15.sp)
                }
                Image(painter = painterResource(id = R.drawable.fitnes),
                    contentDescription = "Doctor",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.padding(top = 10.dp, end = 20.dp))
            }
        }
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ){
            Row (modifier = Modifier.fillMaxWidth()
                .background(color = Color(252, 215, 237), RoundedCornerShape(10.dp)),
                horizontalArrangement = Arrangement.SpaceBetween,
                )
            {
                Column (modifier = Modifier.fillMaxWidth(0.6f)
                    .padding(start = 20.dp, top = 16.dp, bottom = 16.dp)){
                    Text(text = "Yoga", fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(bottom = 15.dp), fontSize = 18.sp)
                    Text(text = "Experience the transformative power of yoga!", fontSize = 11.sp, lineHeight = 15.sp)
                }
                Image(painter = painterResource(id = R.drawable.yoga),
                    contentDescription = "Doctor",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.padding(top = 10.dp, end = 20.dp))
            }
        }
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ){
            Row (modifier = Modifier.fillMaxWidth()
                .background(color = Color(251, 249, 236), RoundedCornerShape(10.dp)),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically)
            {
                Column (modifier = Modifier.fillMaxWidth(0.6f)
                    .padding(start = 20.dp, top = 16.dp, bottom = 16.dp)){
                    Text(text = "Reports and Analysis", fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(bottom = 15.dp), fontSize = 18.sp)
                    Text(text = "Generation insightful reports on your physical activity, health, and medication adherence.", fontSize = 11.sp, lineHeight = 15.sp)
                }
                Image(painter = painterResource(id = R.drawable.analysisreporthealth),
                    contentDescription = "Doctor",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.padding(top = 10.dp, end = 20.dp, bottom = 8.dp))
            }
        }
    }
}

package com.example.myapplication.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.data.TasksToDoData

@Composable
fun CardTasksToDo(tasks: List<TasksToDoData>) {
    LazyColumn {
        items(tasks) { task ->
            TaskCard(task = task)
        }
    }
}

@Composable
fun TaskCard(task: TasksToDoData) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 15.dp, end = 15.dp, bottom = 9.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                CheckBoxState(task = task)

                VerticalLine(task = task)

                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Column (modifier = Modifier.padding(start = 19.dp)) {
                        Text(
                            text = task.title,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 7.dp)
                        )
                        Row {
                            Image(painter = painterResource(R.drawable.speedometer),
                                contentDescription = "None",
                                modifier = Modifier.size(width = 16.dp, height = 16.dp)
                                    .padding(end = 6.dp, top = 4.dp))
                            Text(text = "${task.priority}")
                        }
                    }

                    Row(){
//                        Image(painter = painterResource(R.drawable.clock),
//                            contentDescription = "None",
//                            modifier = Modifier.size(width = 16.dp, height = 16.dp)
//                                .padding(end = 5.dp, top = 4.dp))
                        Text(text = "${task.time}")
                    }
                }

            }
        }
    }
}



@Composable
fun CheckBoxState(task: TasksToDoData) {
    val checkedState = remember { mutableStateOf(task.check) }
    Row (verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(end = 13.dp)){
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it },
        )
    }
}

@Composable
fun VerticalLine(task: TasksToDoData) {
    val categoryColor = task.categoryColor
    Box(
        modifier = Modifier
            .size(width = 5.dp, height = 60.dp)
            .background(categoryColor)
    ) {
    }
}

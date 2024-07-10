package com.example.myapplication.composables.ui
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.material3.Divider
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.myapplication.Model.User
//
//@Composable
//fun UserList(users: List<User>) {
//    Column {
//        Text(text = "User List", fontSize = 20.sp, fontWeight = FontWeight.Bold)
//        Spacer(modifier = Modifier.height(16.dp))
//        LazyColumn {
//            items(users) { user ->
//                Text(text = "Name: ${user.name}\nEmail: ${user.email}", fontSize = 16.sp)
//                Divider()
//            }
//        }
//    }
//}
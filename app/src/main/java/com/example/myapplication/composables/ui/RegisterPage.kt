//package com.example.myapplication.composables.ui
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Call
//import androidx.compose.material.icons.filled.Email
//import androidx.compose.material.icons.filled.KeyboardArrowLeft
//import androidx.compose.material.icons.filled.Lock
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.text.input.VisualTransformation
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import com.example.myapplication.ui.theme.Blue
//
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun RegisterPage(navController: NavController) {
//    val nameValue = remember { mutableStateOf("") }
//    val emailValue = remember { mutableStateOf("") }
//    val phoneValue = remember { mutableStateOf("") }
//    val passwordValue = remember { mutableStateOf("") }
//    val confirmPasswordValue = remember { mutableStateOf("") }
//
//    val passwordVisibility = remember { mutableStateOf(false) }
//    val confirmPasswordVisibility = remember { mutableStateOf(false) }
//
//    var name by rememberSaveable { mutableStateOf("") }
//
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(start = 20.dp, end = 28.dp, top = 10.dp, bottom = 20.dp),
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
//
//
//
//            Row (modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 20.dp)){
//                Icon(imageVector = Icons.Default.KeyboardArrowLeft,
//                    contentDescription = "None",
//                    tint = Color.LightGray,
//                    modifier = Modifier
//                        .size(40.dp)
//                        .clickable { navController.navigate("login_page") },
//                )
//            }
//                Text(
//                    text = "Create Account",
//                    style = TextStyle(
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 25.sp,
//                        )
//                )
//
//            Column( modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 8.dp, top = 40.dp)) {
//
//                HorizontalLineWithMaxWidth()
//
//                    OutlinedTextField(
//                        leadingIcon = {Icon(imageVector = Icons.Default.Person, contentDescription = "", tint = Color.Gray) },
//                        value = name,
//                        onValueChange = { nameValue.value = it },
//                        placeholder = { Text(text = "Name", color = Color.LightGray) },
//                        singleLine = true,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(bottom = 11.dp, top = 11.dp),
//                        colors = TextFieldDefaults.outlinedTextFieldColors(
//                            unfocusedBorderColor = Color.Transparent,
//                        )
//                    )
//
//                    OutlinedTextField(
//                        value = emailValue.value,
//                        onValueChange = { emailValue.value = it },
//                        placeholder = { Text(text = "Email Address", color = Color.LightGray) },
//                        singleLine = true,
//                        leadingIcon = {Icon(imageVector = Icons.Default.Email, contentDescription = "", tint = Color.Gray) },
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(bottom = 11.dp),
//                        colors = TextFieldDefaults.outlinedTextFieldColors(
//                            unfocusedBorderColor = Color.Transparent,
//                        )
//                    )
//
//                    OutlinedTextField(
//                        value = phoneValue.value,
//                        onValueChange = { phoneValue.value = it },
//                        placeholder = { Text(text = "Phone Number", color = Color.LightGray) },
//                        singleLine = true,
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
//                        leadingIcon = {Icon(imageVector = Icons.Default.Call, contentDescription = "", tint = Color.Gray) },
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(bottom = 11.dp),
//                        colors = TextFieldDefaults.outlinedTextFieldColors(
//                            unfocusedBorderColor = Color.Transparent,
//                        )
//
//                    )
//
//                    OutlinedTextField(
//                        leadingIcon = {Icon(imageVector = Icons.Default.Lock, contentDescription = "", tint = Color.Gray) },
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(bottom = 11.dp),
//                        colors = TextFieldDefaults.outlinedTextFieldColors(
//                            unfocusedBorderColor = Color.Transparent,
//                        ),
//                        value = passwordValue.value,
//                        onValueChange = { passwordValue.value = it },
//                        placeholder = { Text(text = "Password", color = Color.LightGray) },
//                        singleLine = true,
//                        trailingIcon = {
//                            IconButton(onClick = {
//                                passwordVisibility.value = !passwordVisibility.value
//                            }) {
//
//                            }
//                        },
//                        visualTransformation = if (passwordVisibility.value) VisualTransformation.None
//                        else PasswordVisualTransformation()
//                    )
//
//                    OutlinedTextField(
//                        leadingIcon = {Icon(imageVector = Icons.Default.Lock, contentDescription = "", tint = Color.Gray) },
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(bottom = 11.dp),
//                        colors = TextFieldDefaults.outlinedTextFieldColors(
//                            unfocusedBorderColor = Color.Transparent,
//                        ),
//                        value = confirmPasswordValue.value,
//                        onValueChange = { confirmPasswordValue.value = it },
//                        placeholder = { Text(text = "Confirm Password", color = Color.LightGray) },
//                        singleLine = true,
//                        trailingIcon = {
//                            IconButton(onClick = {
//                                confirmPasswordVisibility.value = !confirmPasswordVisibility.value
//                            }) {
//
//                            }
//                        },
//                        visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None
//                        else PasswordVisualTransformation()
//                    )
//
//                    HorizontalLineWithMaxWidth()
//
//                    Button(
//                        onClick = { navController.navigate("home") },
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(bottom = 30.dp, top = 40.dp)
//                            .background(color = Blue, RoundedCornerShape(4.dp))
//                    ) {
//                        Text(text = "Create Account", fontWeight = FontWeight.ExtraBold)
//                    }
//
//                    Row (modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.Center) {
//                        Text(text = "Already have a account ?",
//                            fontSize = 14.sp,
//                            fontWeight = FontWeight.Bold,
//                            modifier = Modifier.padding(end = 5.dp),
//                            color = Color.Gray
//                        )
//                        Text(
//                            modifier = Modifier
//                                .clickable {
//                                    navController.navigate("login_page")
//                                },
//                            text = "Login",
//                            fontSize = 14.sp,
//                            fontWeight = FontWeight.Bold,
//                            color = Blue
//                        )
//                    }
//
//
//                }
//
//
//        }
//}
//
//@Composable
//fun HorizontalLineWithMaxWidth() {
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(Color.Transparent) // Set the background color to transparent
//    ) {
//        Divider(
//            modifier = Modifier
//                .fillMaxWidth()
//                .wrapContentWidth(Alignment.CenterHorizontally)
//                .background(Color.LightGray)
//        )
//    }
//}
//
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun HelloContent(name: String, onNameChange: (String) -> Unit) {
//    Column(modifier = Modifier.padding(16.dp)) {
//        Text(
//            text = "Hello, $name",
//            modifier = Modifier.padding(bottom = 8.dp),
//            style = MaterialTheme.typography.bodyMedium
//        )
//        OutlinedTextField(value = name, onValueChange = onNameChange, label = { Text("Name") })
//    }
//}
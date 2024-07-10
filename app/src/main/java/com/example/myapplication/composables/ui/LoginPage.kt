package com.example.myapplication.composables.ui


import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.ui.theme.Blue


@SuppressLint("SuspiciousIndentation")
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(navController: NavController) {
    var isVisibility by remember { mutableStateOf(true) }

    val sharedPreferences: SharedPreferences = LocalContext.current.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)

        LoginPageRegisterPage(
            context = LocalContext.current,
            navController,
            isVisibility,
            sharedPreferences
        ) {
            isVisibility = !isVisibility
        }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPageRegisterPage(
    context: Context,
    navController: NavController,
    isVisibility: Boolean,
    sharedPreferences: SharedPreferences,
    onHideClicked: () -> Unit
) {

    var name by remember { mutableStateOf("") }
    var sname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }
    val passwordVisibility = remember { mutableStateOf(false) }
    val confirmPasswordVisibility = remember { mutableStateOf(false) }

    val txtMsg = remember { mutableStateOf("") }



    if (isVisibility) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(35.dp))

            Text(
                text = "Welcome to",
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                fontFamily = FontFamily.Default,
                color = Blue
            )
            Text(
                text = "TimeGuide",
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(top = 35.dp),
                fontSize = 35.sp,
                fontFamily = FontFamily.Default,
            )
            Text(
                text = "Maximize your time and success",
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(top = 5.dp, bottom = 35.dp),
                fontSize = 13.sp,
                color = Color.Gray
            )

            OutlinedTextField(
                leadingIcon = {Icon(imageVector = Icons.Default.Email, contentDescription = "", tint = Color.Gray) },
                value = email,
                onValueChange = { email = it },
                placeholder = { Text(text = "Email", color = Color.LightGray) },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusRequester.requestFocus() }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),

                )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                leadingIcon = {Icon(imageVector = Icons.Default.Lock, contentDescription = "", tint = Color.Gray)},
                value = password,
                onValueChange = { password = it },
                placeholder = { Text(text = "Password", color = Color.LightGray) },
                visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { /* Handle sign-in here */ }
                ),
            )
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End){
                Text(
                    text = "Forgot password ?",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(8.dp)
                        .clickable {
                            onHideClicked()
                        },
                    textAlign = TextAlign.End,
                    fontSize = 14.sp,
                    color = Blue,
                )
            }


            Button(
                onClick = {
                    val savedEmail: String? = sharedPreferences.getString("email", null)
                    if (email == savedEmail) {
                        val savedPassword: String? = sharedPreferences.getString("password", null)
                        if (password == savedPassword) {
                            navController.navigate("home")
                        } else {
                            Toast.makeText(context, "Incorrect password", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(context, "The email was spelled incorrectly", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp, bottom = 30.dp, top = 30.dp)
                    .background(color = Blue, RoundedCornerShape(4.dp))
            ) {
                Text(text = "Sign In", fontWeight = FontWeight.ExtraBold)
            }

            Row {
                Text(text = "Don't have account ?",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(end = 5.dp),
                    color = Color.DarkGray
                )
                Text(
                    modifier = Modifier
                        .clickable {
                            onHideClicked()
                        },
                    text = "Create an account",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Blue,

                    )
            }
        }

    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(start = 20.dp, end = 28.dp, top = 10.dp, bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {



            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)){
                Icon(imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "None",
                    tint = Color.LightGray,
                    modifier = Modifier
                        .size(40.dp)
                        .clickable { onHideClicked() },
                )
            }
            Text(
                text = "Create Account",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                )
            )

            Column( modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, top = 40.dp)) {

                HorizontalLineWithMaxWidth()


                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    placeholder = { Text(text = "First Name", color = Color.LightGray) },
                    singleLine = true,
                    leadingIcon = {Icon(imageVector = Icons.Default.Person, contentDescription = "", tint = Color.Gray) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 11.dp, top = 11.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color.Transparent,
                    )
                )

                OutlinedTextField(
                    value = sname,
                    onValueChange = { sname = it },
                    placeholder = { Text(text = "Second Name", color = Color.LightGray) },
                    singleLine = true,
                    leadingIcon = {Icon(imageVector = Icons.Default.Person, contentDescription = "", tint = Color.Gray) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 11.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color.Transparent,
                    )
                )

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = { Text(text = "Email Address", color = Color.LightGray) },
                    singleLine = true,
                    leadingIcon = {Icon(imageVector = Icons.Default.Email, contentDescription = "", tint = Color.Gray) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 11.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color.Transparent,
                    )
                )

                OutlinedTextField(
                    value = phone,
                    onValueChange = { phone = it },
                    placeholder = { Text(text = "Phone Number", color = Color.LightGray) },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    leadingIcon = {Icon(imageVector = Icons.Default.Call, contentDescription = "", tint = Color.Gray) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 11.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color.Transparent,
                    )

                )

                OutlinedTextField(
                    leadingIcon = {Icon(imageVector = Icons.Default.Lock, contentDescription = "", tint = Color.Gray) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 11.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color.Transparent,
                    ),
                    value = password,
                    onValueChange = { password = it },
                    placeholder = { Text(text = "Password", color = Color.LightGray) },
                    singleLine = true,
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisibility.value = !passwordVisibility.value
                        }) {

                        }
                    },
                    visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                    else PasswordVisualTransformation()
                )

                OutlinedTextField(
                    leadingIcon = {Icon(imageVector = Icons.Default.Lock, contentDescription = "", tint = Color.Gray) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 11.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color.Transparent,
                    ),
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    placeholder = { Text(text = "Confirm Password", color = Color.LightGray) },
                    singleLine = true,
                    trailingIcon = {
                        IconButton(onClick = {
                            confirmPasswordVisibility.value = !confirmPasswordVisibility.value
                        }) {

                        }
                    },
                    visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None
                    else PasswordVisualTransformation()
                )

                HorizontalLineWithMaxWidth()

                Button(
                    onClick = {
                        if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                            val editor = sharedPreferences.edit()
                            editor.putString("name", name)
                            editor.putString("email", email)
                            editor.putString("password", password)
                            editor.apply()
                            onHideClicked()
                        } else {
                            Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp, bottom = 30.dp, top = 30.dp)
                        .background(color = Blue, RoundedCornerShape(4.dp))
                ) {
                    Text(text = "Sign Up", fontWeight = FontWeight.ExtraBold)
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Already have an account ?",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(end = 5.dp),
                        color = Color.Gray
                    )
                    Text(
                        modifier = Modifier.clickable {
                            onHideClicked()
                        },
                        text = "Login",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Blue
                    )
                }


            }


        }
    }
}


@Composable
fun HorizontalLineWithMaxWidth() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .background(Color.LightGray)
        )
    }
}

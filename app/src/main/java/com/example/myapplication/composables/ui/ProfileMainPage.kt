package com.example.myapplication.composables.ui


import android.Manifest
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.compose.ui.zIndex
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.myapplication.R
import com.example.myapplication.ui.theme.Blue
import com.example.myapplication.ui.theme.Green
import com.example.myapplication.ui.theme.Purplelovelight
import com.example.myapplication.ui.theme.Redlovelight
import com.example.myapplication.ui.theme.Yellow
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Objects


@Composable
fun ProfileMainPage(navController: NavController) {
    val sharedPreferences: SharedPreferences = LocalContext.current.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
    val notification = rememberSaveable { mutableStateOf("") }
    if (notification.value.isNotEmpty()) {
        Toast.makeText(LocalContext.current, notification.value, Toast.LENGTH_LONG).show()
        notification.value = ""
    }

    Column (modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 20.dp, height = 20.dp)
                        .clickable { navController.popBackStack() }
                )
            }

            ProfileImageChanger()

            sharedPreferences.getString("name", null)?.let {
                Text(
                    text = it,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .verticalScroll(rememberScrollState())){
            Button(onClick = {  },
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .background(Redlovelight, RoundedCornerShape(15.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = "None", tint = Color.White)
                Text(
                    text = "Favourites",
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 11.dp)
                )
            }
            Button(onClick = {  },
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .background(Yellow, RoundedCornerShape(15.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "None", tint = Color.White)
                Text(
                    text = "Payment",
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 11.dp)
                )
            }

            Button(onClick = { navController.navigate("setting") },
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .background(Green, RoundedCornerShape(15.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(imageVector = Icons.Default.Settings, contentDescription = "None", tint = Color.White)
                Text(
                    text = "Setting",
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 11.dp)
                )
            }
            Button(onClick = {  },
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .background(Blue, RoundedCornerShape(15.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(imageVector = Icons.Default.Refresh, contentDescription = "None", tint = Color.White)
                Text(
                    text = "Update",
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 11.dp)
                )
            }
            Button(onClick = { navController.navigate("login_page") },
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .background(Purplelovelight, RoundedCornerShape(15.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "None", tint = Color.White)
                Text(
                    text = "Log Out",
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 11.dp)
                )
            }

        }
    }

}





@Composable
fun ProfileImageChanger() {
    val openDialog = remember { mutableStateOf(false) }


    val imageUri = rememberSaveable { mutableStateOf("") }
    val painter = rememberImagePainter(
        imageUri.value.ifEmpty { R.drawable.user }
    )




    val context = LocalContext.current
    val file = context.createImageFile()
    val uri = FileProvider.getUriForFile(
        Objects.requireNonNull(context),
        context.packageName + ".provider", file
    )
    var capturedImageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val cameraLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()){
            capturedImageUri = uri
        }
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){
        if (it)
        {
            Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
            cameraLauncher.launch(uri)
        }
        else
        {
            Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show()
        }
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { capturedImageUri = it }
    }


    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.camera), contentDescription = "None",
            modifier = Modifier
                .size(40.dp)
                .absoluteOffset(50.dp, 130.dp)
                .zIndex(1f)
                .clickable {
                    openDialog.value = !openDialog.value
                }
        )
        Card(
            shape = CircleShape,
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier
                .padding(top = 5.dp, bottom = 20.dp)
                .size(120.dp)
        ) {
            if (capturedImageUri?.path?.isNotEmpty() == true)
            {
                Image(
                    modifier = Modifier
                        .wrapContentSize(),
                    contentScale = ContentScale.Crop,
                    painter = rememberImagePainter(capturedImageUri),
                    contentDescription = null
                )
            }
            else
            {
                Image(
                    modifier = Modifier
                        .wrapContentSize()
                        .scale(0.8f)
                        .background(color = Color.White),
                    contentScale = ContentScale.Inside,
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = null,
                )
            }
        }
    }


    Box {
        if (openDialog.value) {
            Popup(
                alignment = Alignment.TopCenter,
                properties = PopupProperties(),
            ) {
                Box(
                    Modifier
                        .fillMaxSize()
                        .clickable { openDialog.value = false }
                        .background(Color.Gray.copy(alpha = 0.5f)),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(100.dp)
                            .background(Blue, RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp))
                            .padding(top = 20.dp, bottom = 50.dp, end = 20.dp, start = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Profile photo",
                            color = Color.White,
                            modifier = Modifier.padding(bottom = 10.dp),
                            fontSize = 17.sp
                        )

                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Image(painter = painterResource(id = R.drawable.camerafill), contentDescription = "",
                                modifier = Modifier
                                    .size(60.dp)
                                    .clickable {
                                        val permissionCheckResult =
                                            ContextCompat.checkSelfPermission(
                                                context,
                                                Manifest.permission.CAMERA
                                            )

                                        if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) {
                                            cameraLauncher.launch(uri)
                                        } else {
                                            permissionLauncher.launch(Manifest.permission.CAMERA)
                                        }
                                    })

                            Image(painter = painterResource(id = R.drawable.gallery), contentDescription = "",
                                modifier = Modifier
                                    .size(60.dp)
                                    .clickable { launcher.launch("image/*") })
                        }
                    }
                }
            }
        }
    }
}

fun Context.createImageFile(): File {
    val timeStamp = SimpleDateFormat("yyyy_MM_dd_HH:mm:ss").format(Date())
    val imageFileName = "JPEG_" + timeStamp + "_"
    val image = File.createTempFile(
        imageFileName,
        ".jpg",
        externalCacheDir
    )

    return image
}
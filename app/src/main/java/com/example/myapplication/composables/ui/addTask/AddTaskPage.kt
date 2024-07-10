package com.example.myapplication.composables.ui.addTask

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.ui.theme.NeedWhite
import kotlin.math.max

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun AddTaskPage(navController: NavController) {

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(NeedWhite), // Align children with space between them
        ) {
            AddTaskPageScreen(navController)
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .absoluteOffset(x = -5.dp, y = 0.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom
        ) {
            Image(
                modifier = Modifier
                    .size(70.dp)
                    .clickable {
                        navController.navigate("addTask")
                    }
                    .shadow(
                        elevation = 20.dp,
                        ambientColor = Color.Gray,
                        spotColor = Color.Gray,
                        shape = RoundedCornerShape(20.dp)
                    ),
                painter = painterResource(id = R.drawable.done),
                contentDescription = null,
            )
        }
    }
}


@Composable
fun AddTaskPageScreen (navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 15.dp, bottom = 15.dp, start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {

        Row() {
            Image(
                painter = painterResource(id = R.drawable.back),
                contentDescription = null,
                modifier = Modifier.size(width = 20.dp, height = 20.dp)
                    .clickable { navController.popBackStack() }
            )
        }

        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.Center) {
            Text(
                text = "Create Task",
                fontSize = 25.sp,
                fontWeight = FontWeight.ExtraBold,
            )
        }

        // Enter, Date, CheckBox
        Column {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .verticalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.Center,){
                TxtField()
            }
            Row(){
                Button(onClick = { /*TODO*/ },
                    modifier = Modifier
                        .background(Color.Transparent)
                        .border(1.dp, color = Color.LightGray)
                        .padding(0.dp),

                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    Image(
                        painter = painterResource(R.drawable.calendar),
                        contentDescription = "Back",
                        modifier = Modifier
                            .size(width = 30.dp, height = 30.dp)
                            .padding(end = 10.dp)
                    )
                    Text(text = "Due Date", color = Color.Black)
                }
            }
            CheckBoxText()
        }

        // Priority
        Column {
            Text(text = "Priority", fontSize = 19.sp, modifier = Modifier.padding(bottom = 8.dp), color = Color.Gray)
            //HorizontalLine()
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,){
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(138, 201, 38))
                ) {
                    Text(text = "Low")
                }
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(255, 196, 58))
                ) {
                    Text(text = "Medium")
                }
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(255, 89, 94))
                ) {
                    Text(text = "High")
                }
            }
        }


        // Category
        Column(modifier = Modifier.padding(bottom = 80.dp)) {
            Text(text = "Category", fontSize = 19.sp, modifier = Modifier.padding(bottom = 10.dp), color = Color.Gray)
            //HorizontalLine()
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,){
                TagRow(sampleTags)
            }
        }
    }
}


@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TxtField() {
    var value by remember {
        mutableStateOf("")
    }
    val customTextFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = Color(144, 224, 239),
        unfocusedBorderColor = Color.Transparent,
        containerColor = Color.Transparent,
        cursorColor = Color(144, 224, 239),
    )
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Transparent)
            .border(0.5.dp, Color.Transparent),
        value = value,
        onValueChange = { newText ->
            value = newText
        },
        placeholder = { Text(text = "Enter Task Info", color = Color(173, 181, 189), fontSize = 19.sp) },
        colors = customTextFieldColors
    )
}


@Composable
private fun CheckBoxText() {
    val checkedState = remember { mutableStateOf(false) }
    Row (modifier = Modifier.padding(bottom = 15.dp),
        verticalAlignment = Alignment.CenterVertically){
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it },
            modifier = Modifier.padding(end = 5.dp)
        )
        Text("Completed", fontSize = 16.sp)
    }
}

@Composable
fun HorizontalLine() {
    Box(modifier = Modifier.padding(bottom = 12.dp)) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .align(Alignment.BottomStart)
        ) {
            val lineColor = Color.LightGray
            val strokeWidth = 1.dp.toPx()
            drawLine(
                color = lineColor,
                start = Offset(0f, 0f),
                end = Offset(size.width, 0f),
                strokeWidth = strokeWidth,
            )
        }
    }
}



@Composable
fun TagRow(tags: Collection<String>) {
    SimpleFlowRow(
        verticalGap = 11.dp,
        horizontalGap = 11.dp,
        alignment = Alignment.Start,
//        modifier = Modifier.padding(16.dp)
    ) {
        for (tag in tags) {
            Text(
                text = "$tag",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .background(Color(206, 212, 218), RoundedCornerShape(8.dp))
                    .padding(6.dp)
            )
        }
    }
}



@Composable
fun SimpleFlowRow(
    modifier: Modifier = Modifier,
    alignment: Alignment.Horizontal = Alignment.Start,
    verticalGap: Dp = 0.dp,
    horizontalGap: Dp = 0.dp,
    content: @Composable () -> Unit
) = Layout(content, modifier) { measurables, constraints ->
    val hGapPx = horizontalGap.roundToPx()
    val vGapPx = verticalGap.roundToPx()

    val rows = mutableListOf<MeasuredRow>()
    val itemConstraints = constraints.copy(minWidth = 0)

    for (measurable in measurables) {
        val lastRow = rows.lastOrNull()
        val placeable = measurable.measure(itemConstraints)

        if (lastRow != null && lastRow.width + hGapPx + placeable.width <= constraints.maxWidth) {
            lastRow.items.add(placeable)
            lastRow.width += hGapPx + placeable.width
            lastRow.height = max(lastRow.height, placeable.height)
        } else {
            val nextRow = MeasuredRow(
                items = mutableListOf(placeable),
                width = placeable.width,
                height = placeable.height
            )

            rows.add(nextRow)
        }
    }

    val width = rows.maxOfOrNull { row -> row.width } ?: 0
    val height = rows.sumBy { row -> row.height } + max(vGapPx.times(rows.size - 1), 0)

    val coercedWidth = width.coerceIn(constraints.minWidth, constraints.maxWidth)
    val coercedHeight = height.coerceIn(constraints.minHeight, constraints.maxHeight)

    layout(coercedWidth, coercedHeight) {
        var y = 0

        for (row in rows) {
            var x = when(alignment) {
                Alignment.Start -> 0
                Alignment.CenterHorizontally -> (coercedWidth - row.width) / 2
                Alignment.End -> coercedWidth - row.width

                else -> throw Exception("unsupported alignment")
            }

            for (item in row.items) {
                item.place(x, y)
                x += item.width + hGapPx
            }

            y += row.height + vGapPx
        }
    }
}

private data class MeasuredRow(
    val items: MutableList<Placeable>,
    var width: Int,
    var height: Int
)

val sampleTags = listOf(
    "+ Add New Category", "College Work", "Songs", "Interview", "Homework", "Workout"
)
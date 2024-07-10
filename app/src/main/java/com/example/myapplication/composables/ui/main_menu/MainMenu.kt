
import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.data.TasksToDoData
import com.example.myapplication.model.CardTasksToDo
import com.example.myapplication.ui.theme.Blue
import com.example.myapplication.ui.theme.Green
import com.example.myapplication.ui.theme.NeedWhite
import com.example.myapplication.ui.theme.Red
import com.example.myapplication.ui.theme.Yellow
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale


@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun MainMenu(navController: NavController) {

    val todos = remember { mutableMapOf<LocalDate, List<String>>() }
    todos[LocalDate.now()] = listOf("Task 1", "Task 2", "Task 4", "Task 5")
    todos[LocalDate.now().plusDays(1)] = listOf("Task 3", "Task 5")

    val onDateSelected: (LocalDate) -> Unit = { date ->
        println("Selected date: $date")
    }

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(NeedWhite),
            // Add padding to the Column as needed
            verticalArrangement = Arrangement.SpaceBetween, // Align children with space between them
        ) {
            HorizontalScrollableCalendarView(todos, onDateSelected, navController)
        }

        Row (modifier = Modifier.fillMaxSize()
                .absoluteOffset(x = (-5).dp, y = 0.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom){
            Image(
                painter = painterResource(id = R.drawable.add),
                modifier = Modifier
                    .shadow(
                        elevation = 20.dp,
                        ambientColor = Color.Gray,
                        spotColor = Color.Gray,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .size(70.dp)
                    .clickable {
                        navController.navigate("addTask")
                    },
                contentDescription = null,
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HorizontalScrollableCalendarView(
    todos: Map<LocalDate, List<String>>,
    onDateSelected: (LocalDate) -> Unit,
    navController: NavController
) {
    var selectedDate by remember { mutableStateOf<LocalDate?>(LocalDate.now()) }
    val startDate = LocalDate.now() // Adjust as needed
    val endDate = LocalDate.now().plusMonths(3)// Adjust as needed

    val date = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH)
    val formattedDate = formatter.format(date)

    val openDialog = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 11.dp, 20.dp, 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.padding(start = 5.dp)) {
                Text(
                    text = selectedDate?.format(
                        DateTimeFormatter.ofPattern(
                            "dd MMMM yyyy",
                            Locale.ENGLISH
                        )
                    ) ?: formattedDate,
                    color = Color.Gray,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 1.dp)
                )
                Text(
                    text = selectedDate?.let {
                        val currentDate = LocalDate.now()
                        when {
                            it == currentDate -> "Today"
                            it == currentDate.plusDays(1) -> "Tomorrow"
                            it >= currentDate && it <= currentDate.plusDays(6) -> "This week"
                            it >= currentDate.plusDays(7) && it <= currentDate.plusDays(13) -> "Next week"
                            it >= currentDate.plusMonths(1) -> "Next month"
                            else -> it.format(
                                DateTimeFormatter.ofPattern(
                                    "dd MMMM yyyy",
                                    Locale.ENGLISH
                                )
                            )
                        }
                    } ?: "Today",
                    style = TextStyle(fontSize = 28.sp),
                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.padding(start = 40.dp)
                )
            }
            ThreeDots()
        }

        // Horizontal Scrollable Calendar
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(buildCalendar(startDate, endDate)) { date ->
                CalendarItem(
                    date = date,
                    isSelected = date == selectedDate,
                    onDateSelected = {
                        selectedDate = it
                        onDateSelected(it)
                    },
                    todos = todos[date] ?: emptyList()
                )
            }
        }

        var selectedItem by remember { mutableStateOf<String?>("All") }
        val items = listOf("All", "Work", "Sport", "Health", "High", "Medium", "Low", "Homework")
        HorizontalScrollableList(
            items = items,
            selected = selectedItem,
            onItemSelected = { newItem ->
                selectedItem = if (selectedItem == newItem) null else newItem
            }
        )


        if (selectedDate == LocalDate.now()) {
            TaskListScreenToday(NavController)
        } else if (selectedDate == LocalDate.now().plusDays(1)) {
            TaskListScreenTomorrow(NavController)
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
fun buildCalendar(startDate: LocalDate, endDate: LocalDate): List<LocalDate> {
    val dates = mutableListOf<LocalDate>()
    var current = startDate
    while (!current.isAfter(endDate) ) {
        dates.add(current)
        current = current.plusDays(1)
    }
    return dates
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarItem(
    date: LocalDate,
    isSelected: Boolean,
    onDateSelected: (LocalDate) -> Unit,
    todos: List<String>
) {
    Box(
        modifier = Modifier
            .background(
                if (isSelected) Color(156, 170, 253) else Color.Transparent,
                RoundedCornerShape(30.dp)
            )
            .padding(start = 9.dp, end = 9.dp, top = 20.dp, bottom = 20.dp)
            .clickable { onDateSelected(date) },
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = date.dayOfWeek.toString().substring(0,2),
                color = if (isSelected) Color.White else Color.Black,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                fontSize = 15.sp,
            )
            Text(
                text = date.dayOfMonth.toString(),
                color = if (isSelected) Color.White else Color.Black,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                fontSize = 15.sp,
            )
            Text(
                text = "${todos.size} todos",
                color = if (isSelected) Color.LightGray else Color.DarkGray,
                fontSize = 11.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
            )
        }
    }
}


@Composable
fun HorizontalScrollableList(
    items: List<String>,
    selected: String?,
    onItemSelected: (String) -> Unit,
    ) {
    LazyRow(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 0.dp, start = 13.dp, end = 13.dp, bottom = 5.dp)) {
        items(items) { item ->
            val isSelected = item == selected
            Box(modifier = Modifier
                .padding(8.dp)
                .clickable {
                    onItemSelected(item)
                }
            ) {
                Text(text = item,
                    color = if (isSelected) Color.Black else Color.Gray,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                )
            }
        }
    }
}









@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TaskListScreenToday(navController: NavController.Companion) {
    val tasksList = generateTasksForDate(LocalDate.now())
    CardTasksToDo(tasks = tasksList)
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TaskListScreenTomorrow(navController: NavController.Companion) {
    val tasksList = generateTasksForDate(LocalDate.now().plusDays(1))
    CardTasksToDo(tasks = tasksList)
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun generateTasksForDate(date: LocalDate): List<TasksToDoData> {
    // Implement your logic to generate tasks for the given date
    // Example: Return different tasks for different dates
    return when (date) {
        LocalDate.now() -> {
            listOf(
                TasksToDoData(false, Blue, "Running", "08:00", "High"),
                TasksToDoData(false, Green, "Yoga", "09:15", "Low"),
                TasksToDoData(false, Red, "Project Research", "12:00", "Medium"),
                TasksToDoData(false, Yellow, "Wash the floor", "17:30", "Medium"),
            )
        }
        LocalDate.now().plusDays(1) -> {
            listOf(
                TasksToDoData(false, Red, "Team Work", "12:05", "High"),
                TasksToDoData(false, Green, "Cook Dinner", "18:40", "Medium")
            )
        }
        else -> emptyList()
    }
}





@Composable
fun ThreeDots() {
    val openDialog = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.End
    ) {
        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "None",
            modifier = Modifier
                .size(width = 49.dp, height = 49.dp)
                .padding(top = 15.dp)
                .absolutePadding(left = 20.dp)
                .clickable {
                    openDialog.value = !openDialog.value
                },
            )
    }


    Box {
        if (openDialog.value) {
            Popup(
                alignment = Alignment.TopCenter,
                properties = PopupProperties(),
            ) {
                Box(
                    Modifier
                        .fillMaxWidth(0.7f)
                        .padding(end = 10.dp)
                        .clickable { openDialog.value = false },
                        contentAlignment = Alignment.TopEnd,
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White, RoundedCornerShape(10.dp))
                            .padding(top = 20.dp, bottom = 20.dp, end = 20.dp, start = 20.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Sort by",
                            color = Color.Black,
                            modifier = Modifier.padding(bottom = 10.dp),
                            fontSize = 17.sp
                        )
                        Text(
                            text = "Change the theme",
                            color = Color.Black,
                            modifier = Modifier.padding(bottom = 10.dp),
                            fontSize = 17.sp
                        )
                        Text(
                            text = "Hide completed tasks",
                            color = Color.Black,
                            modifier = Modifier.padding(bottom = 10.dp),
                            fontSize = 17.sp
                        )
                    }
                }
            }
        }
    }
}

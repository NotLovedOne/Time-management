package com.example.myapplication.composables.menu_composables.health

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun FitnessScreen(
) {


    val exerciseList = listOf(
        Exercise(
            id = 1,
            name = "Push-Up",
            description = "A classic upper body exercise that targets the chest, shoulders, and triceps.",
            reps = 10,
            sets = 3,
            imageUrl = "https://example.com/pushup_image.jpg"
        ),
        Exercise(
            id = 2,
            name = "Squat",
            description = "A lower body exercise that works the quadriceps, hamstrings, and glutes.",
            reps = 12,
            sets = 3,
            imageUrl = "https://example.com/squat_image.jpg"
        ),
        Exercise(
            id = 3,
            name = "Plank",
            description = "A core-strengthening exercise that also engages the shoulders and back.",
            reps = 1,  // Duration in seconds
            sets = 3,
            imageUrl = "https://example.com/plank_image.jpg"
        ),
        Exercise(
            id = 4,
            name = "Lunges",
            description = "A lower body exercise that targets the quadriceps and glutes.",
            reps = 10,  // Each leg
            sets = 3,
            imageUrl = "https://example.com/lunges_image.jpg"
        ),
        Exercise(
            id = 5,
            name = "Bicycle Crunch",
            description = "An abdominal exercise that works the obliques and rectus abdominis.",
            reps = 15,  // Each side
            sets = 3,
            imageUrl = "https://example.com/bicycle_crunch_image.jpg"
        ),
        Exercise(
            id = 6,
            name = "Pull-Up",
            description = "An upper body exercise that primarily targets the back and biceps.",
            reps = 8,
            sets = 3,
            imageUrl = "https://example.com/pullup_image.jpg"
        ),
        Exercise(
            id = 7,
            name = "Jumping Jacks",
            description = "A cardio exercise that raises the heart rate and engages the entire body.",
            reps = 20,
            sets = 3,
            imageUrl = "https://example.com/jumping_jacks_image.jpg"
        ),
        Exercise(
            id = 8,
            name = "Deadlift",
            description = "A compound exercise that targets the lower back, glutes, and hamstrings.",
            reps = 5,
            sets = 5,
            imageUrl = "https://example.com/deadlift_image.jpg"
        ),
        Exercise(
            id = 9,
            name = "Mountain Climbers",
            description = "A full-body exercise that emphasizes the core and cardio fitness.",
            reps = 20,  // Each leg
            sets = 3,
            imageUrl = "https://example.com/mountain_climbers_image.jpg"
        ),
        Exercise(
            id = 10,
            name = "Yoga Downward Dog",
            description = "A yoga pose that stretches the entire body and promotes flexibility.",
            reps = 1,  // Duration in seconds
            sets = 3,
            imageUrl = "https://example.com/yoga_downward_dog_image.jpg"
        ),
    )

    ExerciseList(exerciseList)
}



@Composable
fun ExerciseList(exercises: List<Exercise>) {
    LazyColumn {
        items(exercises) { exercise ->
            ExerciseCard(exercise = exercise)
        }
    }
}

data class Exercise(
    val id: Int,
    val name: String,
    val description: String,
    val reps: Int,
    val sets: Int,
    val imageUrl: String
)

@Composable
fun ExerciseCard(exercise: Exercise) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = exercise.name, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Reps: ${exercise.reps}")
            Text(text = "Sets: ${exercise.sets}")
        }
    }
}

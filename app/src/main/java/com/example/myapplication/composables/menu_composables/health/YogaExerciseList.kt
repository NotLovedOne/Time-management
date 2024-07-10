package com.example.myapplication.composables.menu_composables.health

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
fun YogaExerciseList() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        items(yogaExerciseList) { yogaExercise ->
            YogaExerciseCard(yogaExercise = yogaExercise)
            Spacer(modifier = Modifier.height(16.dp)) // Add spacing between items
        }
    }
}

@Composable
fun YogaExerciseCard(yogaExercise: YogaExercise) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = yogaExercise.name, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = yogaExercise.description)
            Spacer(modifier = Modifier.height(8.dp))

        }
    }
}
data class YogaExercise(
    val id: Int,             // Unique identifier for the yoga exercise
    val name: String,        // Name of the yoga exercise
    val description: String, // Description or instructions for the yoga exercise
    val imageUrl: String     // URL to an image illustrating the yoga exercise
)

val yogaExerciseList = listOf(
    YogaExercise(
        id = 1,
        name = "Child's Pose",
        description = "Child's Pose, or Balasana, is a resting yoga pose that stretches the hips, thighs, and lower back. It's a great relaxation and stress-reduction pose.",
        imageUrl = "https://example.com/childs_pose_image.jpg"
    ),
    YogaExercise(
        id = 2,
        name = "Downward-Facing Dog",
        description = "Downward-Facing Dog, or Adho Mukha Svanasana, is a foundational yoga pose that stretches and strengthens the entire body, including the arms, legs, and spine.",
        imageUrl = "https://example.com/downward_dog_image.jpg"
    ),
    YogaExercise(
        id = 3,
        name = "Warrior II",
        description = "Warrior II, or Virabhadrasana II, is a standing yoga pose that improves strength, balance, and focus. It also opens up the hips and chest.",
        imageUrl = "https://example.com/warrior_ii_image.jpg"
    ),
    YogaExercise(
        id = 4,
        name = "Tree Pose",
        description = "Tree Pose, or Vrikshasana, is a balance pose that strengthens the legs and improves concentration. It's a great way to find inner peace and stability.",
        imageUrl = "https://example.com/tree_pose_image.jpg"
    ),
    // Add more yoga exercises here...
)

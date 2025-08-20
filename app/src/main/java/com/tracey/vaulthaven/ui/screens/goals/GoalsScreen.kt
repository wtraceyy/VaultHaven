package com.tracey.vaulthaven.ui.screens.goals

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tracey.vaulthaven.navigation.ROUT_ADDGOALS
import com.tracey.vaulthaven.navigation.ROUT_BUDGET
import com.tracey.vaulthaven.navigation.ROUT_HOME
import com.tracey.vaulthaven.ui.theme.Dblue

// 🔹 Model for a Goal
data class Goal(
    val title: String,
    val targetAmount: Int,
    val savedAmount: Int,
    val deadline: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoalsScreen(navController: NavController) {
    // Two lists: active goals and completed goals
    val activeGoals = remember {
        mutableStateListOf(
            Goal("Vacation to Mombasa", 50000, 20000, "Dec 2025"),
            Goal("New Laptop", 120000, 60000, "Jun 2026"),
            Goal("Emergency Fund", 100000, 75000, "Ongoing")
        )
    }

    val completedGoals = remember { mutableStateListOf<Goal>() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Goals") },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(ROUT_BUDGET)

                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "menu"
                        )
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Dblue,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(ROUT_ADDGOALS)},
                containerColor = Dblue,
                shape = CircleShape,
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Goal", tint = Color.White)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // 🔹 Active Goals Section
            Text("Active Goals", style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(8.dp))

            if (activeGoals.isEmpty()) {
                Text("No active goals, add one to get started!")
            } else {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    items(activeGoals, key = { it.title }) { goal ->
                        GoalCard(goal = goal, onComplete = {
                            activeGoals.remove(goal)
                            completedGoals.add(goal)
                        })
                    }
                }
            }

            Spacer(Modifier.height(24.dp))

            // 🔹 Completed Goals Section
            if (completedGoals.isNotEmpty()) {
                Text("Completed Goals", style = MaterialTheme.typography.titleMedium)
                Spacer(Modifier.height(8.dp))

                LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    items(completedGoals, key = { it.title }) { goal ->
                        CompletedGoalCard(goal)
                    }
                }
            }
        }
    }
}

// 🔹 Card for Active Goals
@Composable
fun GoalCard(goal: Goal, onComplete: () -> Unit) {
    val progress = goal.savedAmount.toFloat() / goal.targetAmount.toFloat()

    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(Modifier.padding(16.dp)) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(goal.title, style = MaterialTheme.typography.titleMedium)

                // ✅ Mark as complete
                IconButton(onClick = onComplete) {
                    Icon(
                        Icons.Default.CheckCircle,
                        contentDescription = "Complete",
                        tint = Dblue
                    )
                }
            }

            Text("Target: KSh ${goal.targetAmount}", color = Color.Gray)
            Text("Saved: KSh ${goal.savedAmount}")

            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .height(8.dp),
                color =  Dblue,
                trackColor = Color.LightGray.copy(alpha = 0.3f)
            )

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("${(progress * 100).toInt()}% Complete")
                Text("Deadline: ${goal.deadline}")
            }
        }
    }
}

// 🔹 Card for Completed Goals
@Composable
fun CompletedGoalCard(goal: Goal) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray.copy(alpha = 0.2f))
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(goal.title, style = MaterialTheme.typography.titleMedium, color = Color.Gray)
            Text("Target: KSh ${goal.targetAmount}", color = Color.Gray)
            Text("✅ Completed!", color = Dblue)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GoalsScreenPreview() {
    GoalsScreen(rememberNavController())
}


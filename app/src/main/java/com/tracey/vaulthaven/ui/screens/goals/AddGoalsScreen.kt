package com.tracey.vaulthaven.ui.screens.goals

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tracey.vaulthaven.R
import com.tracey.vaulthaven.ui.theme.Dblue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddGoalsScreen(
    onBack: () -> Unit,
    onSave: (Goal) -> Unit

) {

    var title by remember { mutableStateOf("") }
    var targetAmount by remember { mutableStateOf("") }
    var savedAmount by remember { mutableStateOf("") }
    var deadline by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add New Goal") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Dblue,
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.goals),
                contentDescription = "shoe",
                modifier = Modifier.width(250.dp).height(150.dp)
                    .padding(top = 5.dp, start = 130.dp),
            )

            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Goal Title") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(Dblue,
                    focusedBorderColor = Dblue,
                    cursorColor = Dblue
                )
            )

            OutlinedTextField(
                value = targetAmount,
                onValueChange = { targetAmount = it },
                label = { Text("Target Amount (KSh)") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(Dblue,
                    focusedBorderColor = Dblue,
                    cursorColor = Dblue
                )
            )

            OutlinedTextField(
                value = savedAmount,
                onValueChange = { savedAmount = it },
                label = { Text("Already Saved (KSh)") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(Dblue,
                    focusedBorderColor = Dblue,
                    cursorColor = Dblue
                )
            )

            OutlinedTextField(
                value = deadline,
                onValueChange = { deadline = it },
                label = { Text("Deadline") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(Dblue,
                    focusedBorderColor = Dblue,
                    cursorColor = Dblue
                )
            )

            Button(
                onClick = {
                    val goal = Goal(
                        title = title,
                        targetAmount = targetAmount.toIntOrNull() ?: 0,
                        savedAmount = savedAmount.toIntOrNull() ?: 0,
                        deadline = deadline.ifEmpty { "No deadline" }
                    )
                    onSave(goal)
                    onBack()
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Dblue)
            ) {
                Text("Save Goal")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddGoalsScreenPreview() {
    AddGoalsScreen(
        onBack = {},  // fake navigation
        onSave = {}   // fake save
    )
}





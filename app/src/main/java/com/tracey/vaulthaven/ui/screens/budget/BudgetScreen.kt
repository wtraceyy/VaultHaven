package com.tracey.vaulthaven.ui.screens.budget

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tracey.vaulthaven.navigation.ROUT_BUDGET
import com.tracey.vaulthaven.navigation.ROUT_HOME
import com.tracey.vaulthaven.navigation.ROUT_NOTIFICATIONS
import com.tracey.vaulthaven.navigation.ROUT_PROFILE
import com.tracey.vaulthaven.navigation.ROUT_TRANSACTIONS
import com.tracey.vaulthaven.navigation.ROUT_UTILITIES
import com.tracey.vaulthaven.ui.theme.Bblue
import com.tracey.vaulthaven.ui.theme.Dblue


//ADD OR VIEW SAVING GOALS
//USERS TO SET MONTHLY SPENDING LIMITS (for individual categories and overall spending limits)
//NOTIFY USERS WHEN APPROACHING OR EXCEEDING BUDGET
//SHOW PROGRESS BARS OR CHARTS INDICATING HOW MUCH BUDGET IS USED


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BudgetScreen(navController: NavController){


    var selectedIndex by remember { mutableStateOf(0) }


    Scaffold(
        //TopBar
        topBar = {
            TopAppBar(

                title = { Text("Hi Tracey,") },

                colors = TopAppBarDefaults.topAppBarColors(
                    titleContentColor = androidx.compose.ui.graphics.Color.White,
                    navigationIconContentColor = androidx.compose.ui.graphics.Color.White,
                    actionIconContentColor = Color.White,
                    containerColor = Dblue

                    ),
                actions = {
                    IconButton(onClick = {
                        navController.navigate(ROUT_NOTIFICATIONS)
                    }) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notify"
                        )
                    }
                }



            )


        },

        //BottomBar
        bottomBar = {
            NavigationBar(
                containerColor = Dblue


            ){
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "",tint = Color.White) },
                    label = { Text("Home", color = Color.White) },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1
                        //navController.navigate(ROUT_HOME)
                        navController.navigate(ROUT_HOME)
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Bblue
                    )

                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.DateRange, contentDescription = "",tint = Color.White) },
                    label = { Text("Records", color = Color.White) },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2
                        // navController.navigate(ROUT_HOME)
                        navController.navigate(ROUT_TRANSACTIONS)

                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Bblue
                    )
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Money, contentDescription = "",tint = Color.White) },
                    label = { Text("Budget", color = Color.White) },
                    selected = selectedIndex == 0,
                    onClick = { selectedIndex = 0
                        // navController.navigate(ROUT_HOME)
                        navController.navigate(ROUT_BUDGET)

                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Bblue
                    )
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.AccountCircle, contentDescription = "Profile",tint = Color.White) },
                    label = { Text("Profile", color = Color.White) },
                    selected = selectedIndex == 5,
                    onClick = { selectedIndex = 5
                        //  navController.navigate(ROUT_HOME)
                        navController.navigate(ROUT_PROFILE)

                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Bblue
                    )
                )

                NavigationBarItem(
                    icon = { Icon(Icons.Default.MoreVert, contentDescription = "Profile",tint = Color.White) },
                    label = { Text("More", color = Color.White) },
                    selected = selectedIndex == 3,
                    onClick = { selectedIndex = 3
                        //  navController.navigate(ROUT_HOME)
                        navController.navigate(ROUT_UTILITIES)

                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Bblue
                    )
                )

            }
        },


        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),

                ){


                // Add or View Saving Goals
                Card(
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(6.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text("Saving Goals", style = MaterialTheme.typography.titleMedium)
                        Text("Add or view your saving goals", color = Color.Gray)
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(containerColor = Dblue)
                        ) {
                            Icon(Icons.Default.Savings, contentDescription = null, tint = Color.White)
                            Spacer(Modifier.width(8.dp))
                            Text("Manage Goals", color = Color.White)
                        }
                    }
                }

                // Monthly Spending Limits
                Card(
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(6.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text("Monthly Spending Limits", style = MaterialTheme.typography.titleMedium)
                        Text("Set limits for categories & overall", color = Color.Gray)

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.AttachMoney, contentDescription = null, tint = Dblue)
                            Spacer(Modifier.width(6.dp))
                            Text("Overall Limit: KES 50,000", fontWeight = FontWeight.Bold)
                        }

                        Spacer(Modifier.height(8.dp))

                        CategoryLimitItem("Food", Icons.Default.Fastfood, 0.6f, Dblue, "KES 15,000")
                        CategoryLimitItem("Transport", Icons.Default.DirectionsCar, 0.4f, Dblue, "KES 8,000")
                        CategoryLimitItem("Entertainment", Icons.Default.Star, 0.7f,Dblue, "KES 10,000")

                    }
                }

                // Notifications
                Card(
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(6.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text("Budget Notifications", style = MaterialTheme.typography.titleMedium)
                        Text("You will be notified when nearing or exceeding your budget", color = Color.Gray)
                        AssistChip(
                            onClick = {navController.navigate(ROUT_NOTIFICATIONS)},
                            label = { Text("Enabled", color = Color.Black) },
                            leadingIcon = {
                                Icon(Icons.Default.Notifications, contentDescription = null, tint = Dblue)
                            },
                            colors = AssistChipDefaults.assistChipColors(
                                containerColor = Dblue.copy(alpha = 0.1f),
                                labelColor = Color.White
                            )
                        )
                    }
                }

                // Budget Progress Donut
                Card(
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(6.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Budget Usage", style = MaterialTheme.typography.titleMedium)
                        Text("Track how much of your budget is used", color = Color.Gray)

                        Spacer(Modifier.height(16.dp))

                        // Placeholder donut chart (replace with actual chart library if needed)
                        Box(contentAlignment = Alignment.Center) {
                            Canvas(modifier = Modifier.size(150.dp)) {
                                drawArc(
                                    color = Dblue.copy(alpha = 0.3f),
                                    startAngle = 0f,
                                    sweepAngle = 360f,
                                    useCenter = false,
                                    style = Stroke(width = 20f)
                                )
                                drawArc(
                                    color = Dblue,
                                    startAngle = -90f,
                                    sweepAngle = 270f, // 75%
                                    useCenter = false,
                                    style = Stroke(width = 20f, cap = StrokeCap.Round)
                                )
                            }
                            Text("75%")
                        }
                    }

                }

             }
        }

    )//end of scaffold


}//end of nav contoller


@Composable
fun CategoryLimitItem(
    category: String,
    icon: ImageVector,
    progress: Float,  // 0f to 1f
    color: Color,
    amount: String
) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = null, tint = color)
            Spacer(Modifier.width(6.dp))
            Text("$category - $amount", style = MaterialTheme.typography.bodyMedium)
        }
        LinearProgressIndicator(
            progress = progress.coerceIn(0f, 1f), // Use this for most Material3 versions
            // progress = { progress.coerceIn(0f, 1f) }, // Uncomment this if your version requires lambda
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            color = color,
            trackColor = color.copy(alpha = 0.15f)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun BudgetScreenPreview() {
    BudgetScreen(rememberNavController())
}

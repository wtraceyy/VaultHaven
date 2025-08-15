package com.tracey.vaulthaven.ui.screens.notifications

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tracey.vaulthaven.R
import com.tracey.vaulthaven.navigation.ROUT_BUDGET
import com.tracey.vaulthaven.ui.screens.transactions.TransactionsScreen
import com.tracey.vaulthaven.ui.theme.Dblue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationsScreen(navController: NavController) {
    val notifications = listOf(
        NotificationItem("Payment Received", "You received KSh 2,000 from John", "Today, 9:42 AM", R.drawable.paymentsuccess),
        NotificationItem("Low Balance Alert", "Your balance is below KSh 500", "Yesterday, 4:15 PM", R.drawable.warning),
        NotificationItem("Budget Limit Reached", "You've reached your August budget limit", "Aug 10, 11:30 AM", R.drawable.budget),
        NotificationItem("New Feature", "Try our new currency converter!", "Aug 8, 3:45 PM", R.drawable.star)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Notifications") },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Dblue,
                    actionIconContentColor = Color.White,
                    titleContentColor = Color.White,
                ),

                actions = {
                    IconButton(onClick = { /* mark all as read */navController.navigate(ROUT_BUDGET) }) {
                        Icon(Icons.Default.Check, contentDescription = "Mark all as read")
                    }
                }
            )
        }
        
    ) { padding ->
        if (notifications.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.empty),
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(80.dp)
                )
                Spacer(Modifier.height(8.dp))
                Text("No notifications yet", color = Color.Gray)
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .background(Color(0xFFF0F8F7))
            ) {
                items(notifications) { item ->
                    NotificationCard(item)
                }
            }
        }
    }
}

@Composable
fun NotificationCard(item: NotificationItem) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = item.iconRes),
                contentDescription = null,
                tint = Dblue,
                modifier = Modifier.size(25.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(item.title, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(4.dp))

                Text(item.description, color = Color.Gray, fontSize = 14.sp)
                Spacer(Modifier.height(5.dp))
                Text(item.time, color = Color.Gray, fontSize = 12.sp)
            }
        }
    }
}

data class NotificationItem(
    val title: String,
    val description: String,
    val time: String,
    val iconRes: Int
)

@Preview(showBackground = true)
@Composable
fun NotificationsScreenPreview() {
    NotificationsScreen(rememberNavController())
}
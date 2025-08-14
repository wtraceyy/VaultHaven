package com.tracey.vaulthaven.ui.screens.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tracey.vaulthaven.R
import com.tracey.vaulthaven.ui.screens.utilities.UtilitiesScreen
import com.tracey.vaulthaven.ui.theme.Bblue
import com.tracey.vaulthaven.ui.theme.Dark
import com.tracey.vaulthaven.ui.theme.Dblue

@Composable
fun ProfileScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // Scrollable
            .background(Color(0xFFF8F8F8))
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(Dblue, Bblue, Dblue),
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .border(4.dp, Color.White, CircleShape)
                    .shadow(6.dp, CircleShape)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tlogo),
                    contentDescription = "Profile Picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(CircleShape).size(120.dp)
                )
            }
        }

        Spacer(Modifier.height(70.dp))

        // Name & Bio
        Text(
            text = "Tracey W.",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "A web developing learner ",
            fontSize = 14.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(20.dp))

        // Stats
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            StatCard("Transactions", "1,248")
            StatCard("Savings", "KES 84K")
            StatCard("Rewards", "320pts")
        }

        Spacer(Modifier.height(20.dp))

        // Buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(
                onClick = { },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Dblue)
            ) {
                Text("Edit Profile", color = Color.White)
            }
            OutlinedButton(
                onClick = { },
                modifier = Modifier.weight(1f),
                border = BorderStroke(1.dp,  color = Dblue)
            ) {
                Text("Settings", color = Dblue)
            }
        }

        Spacer(Modifier.height(30.dp))

        // Settings Section (same page)
        SettingsCard()
        Spacer(Modifier.height(30.dp))
    }
}

@Composable
fun StatCard(title: String, value: String) {
    Card(
        modifier = Modifier
            .height(80.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = value, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = title, fontSize = 12.sp, color = Color.Gray)
        }
    }
}

@Composable
fun SettingsCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column {
            SettingItem("Clear Cache") { /* Handle click */ }
            Divider()
            SettingItem("Clear History") { /* Handle click */ }
            Divider()
            SettingItem("Languages") { /* Handle click */ }
            Divider()
            SettingItem("Log Out", textColor = Color.Red) { /* Handle click */ }
        }
    }
}

@Composable
fun SettingItem(title: String, textColor: Color = Color.Black, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title, color = textColor, fontSize = 16.sp)
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = null,
            tint = Color.Gray
        )
    }







}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(rememberNavController())
}

package com.tracey.vaulthaven.ui.screens.about

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CardGiftcard
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tracey.vaulthaven.R
import com.tracey.vaulthaven.ui.theme.Bblue
import com.tracey.vaulthaven.ui.theme.Dblue

@Composable
fun AboutScreen(navController: NavController){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F8))
    ) {
        // Wavy Header
        Box(modifier = Modifier.height(200.dp)) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val path = Path().apply {
                    moveTo(0f, size.height * 0.75f)
                    quadraticBezierTo(
                        size.width / 2, size.height,
                        size.width, size.height * 0.75f
                    )
                    lineTo(size.width, 0f)
                    lineTo(0f, 0f)
                    close()
                }
                drawPath(
                    path = path,
                    brush = Brush.verticalGradient(
                        listOf(Dblue, Bblue,Dblue)
                    )
                )
            }
            Text(
                text = "About VaultHaven",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 40.dp)
            )
            Spacer(Modifier.height(15.dp))

            Image(
                painter = painterResource(id = R.drawable.vlogo), // your logo
                contentDescription = "App Logo",
                modifier = Modifier.size(230.dp).padding(top = 40 .dp , start = 130.dp)
            )
        }

        Spacer(Modifier.height(15.dp))

        // Mission Statement
        Text(
            text = "VaultHaven helps you manage money effortlessly, track spending, and stay in control — all in one secure, beautiful app.",
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 24.dp)
        )

        Spacer(Modifier.height(24.dp))

        // Feature List
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            FeatureItem(Icons.Default.Lock, "Bank-level security for all your transactions.")
            FeatureItem(Icons.Default.Send, "Instant transfers, anytime, anywhere.")
            FeatureItem(Icons.Default.TrendingUp, "Smart budgeting and spending insights.")
            FeatureItem(Icons.Default.CardGiftcard, "Earn rewards and cashback.")
        }

        Spacer(Modifier.height(24.dp))

        // Contact Info
        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = CardDefaults.cardColors(Dblue)

        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Contact Us", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Spacer(Modifier.height(8.dp))
                Text("Email: wtraceyy@gmail.com", color = Color.White)
                Spacer(Modifier.height(5.dp))
                Text("Telephone : +254712189425", color = Color.White)
            }
        }

        Spacer(Modifier.height(16.dp))

        // Version & Legal
        Text(
            text = "Version 1.0.0 • Privacy Policy • Terms of Service",
            color = Color.Black,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}

@Composable
fun FeatureItem(icon: ImageVector, description: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Dblue,
            modifier = Modifier.size(24.dp)
        )
        Spacer(Modifier.width(12.dp))
        Text(description, fontSize = 14.sp, color = Color.Black)
    }



}

@Preview(showBackground = true)
@Composable
fun AboutScreenPreview() {
    AboutScreen(rememberNavController())
}

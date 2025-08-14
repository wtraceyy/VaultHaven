package com.tracey.vaulthaven.ui.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tracey.vaulthaven.navigation.ROUT_HOME
import com.tracey.vaulthaven.navigation.ROUT_TRANSACTIONS
import com.tracey.vaulthaven.ui.theme.Bblue
import com.tracey.vaulthaven.ui.theme.Dblue


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {
 Column(

 ) {
         //TopAppBar
         TopAppBar(
             title = { Text(text = "DASHBOARD") },
             colors = TopAppBarDefaults.topAppBarColors(
                 containerColor = Dblue,
                 titleContentColor = Color.White,
                 navigationIconContentColor = Color.White,
                 actionIconContentColor = Color.White,
             ),
             actions = {

                 IconButton(onClick = {
                     navController.navigate(ROUT_HOME)

                 }) {
                     Icon(
                         imageVector = Icons.Default.ArrowForward,
                         contentDescription = "cart"
                     )
                 }
             }
         )

     Spacer(modifier = Modifier.height(16.dp))

     Column(
         modifier = Modifier.padding(start = 16.dp , end = 16.dp)
             .fillMaxSize(),
         verticalArrangement = Arrangement.spacedBy(10.dp)
     ) {
         // First row of 2 cards
         Row(
             modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp),
             horizontalArrangement = Arrangement.spacedBy(16.dp)
         ) {
             SmallStatCard(

                 title = "Total Transactions",
                 value = "152",
                 modifier = Modifier
                     .weight(1f)
                     .height(120.dp)
             )
             SmallStatCard(
                 title = "Saving Progress",
                 value = "60 %",
                 modifier = Modifier
                     .weight(1f)
                     .height(120.dp)
             )
         }

         Spacer(modifier = Modifier.height(10.dp))



         Card(
             modifier = Modifier.fillMaxWidth(),
             shape = RoundedCornerShape(16.dp),
             elevation = CardDefaults.cardElevation(6.dp)
         ) {
             Column(modifier = Modifier.padding(16.dp)) {
                 Text("Monthly Budget Usage", fontWeight = FontWeight.Bold)
                 Spacer(modifier = Modifier.height(8.dp))
                 LinearProgressIndicator(
                     progress = 0.65f,
                     modifier = Modifier
                         .fillMaxWidth()
                         .height(10.dp),
                     color = Dblue,
                     trackColor = Bblue
                 )
                 Spacer(modifier = Modifier.height(4.dp))
                 Text("65% of your monthly budget used")
             }
         }

         Spacer(modifier = Modifier.height(10.dp))

         // Savings Goal Progress
         Card(
             modifier = Modifier.fillMaxWidth(),
             shape = RoundedCornerShape(16.dp),
             elevation = CardDefaults.cardElevation(6.dp)
         ) {
             Column(modifier = Modifier.padding(16.dp)) {
                 Text("Savings Goal Progress", fontWeight = FontWeight.Bold)
                 Spacer(modifier = Modifier.height(8.dp))
                 LinearProgressIndicator(
                     progress = 0.4f,
                     modifier = Modifier
                         .fillMaxWidth()
                         .height(10.dp),
                     color = Dblue,
                     trackColor = Bblue
                 )
                 Spacer(modifier = Modifier.height(4.dp))
                 Text("KES 8,000 saved out of KES 20,000 goal")
             }
         }

         Spacer(modifier = Modifier.height(10.dp))

         // Insights
         Text(
             text = "Insights",
             style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
             color = Dblue
         )

         Spacer(modifier = Modifier.height(5.dp))

         InsightCard("Transport spending is down 12% from last month ")
         Spacer(modifier = Modifier.height(5.dp))
         InsightCard("You are on track to meet your savings goal ")
         Spacer(modifier = Modifier.height(5.dp))
         InsightCard("Dining expenses are 5% higher than last month ")
     }
 }

}

@Composable
fun SmallStatCard(title: String, value: String) {
    Card(
        modifier = Modifier
            .height(100.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = value, style = MaterialTheme.typography.titleLarge, color = Dblue)
        }
    }
}

@Composable
fun InsightCard(text: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
        ) {
            Text(text)
        }
    }
}


@Composable
fun SmallStatCard(title: String, value: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = value,
                style = MaterialTheme.typography.titleLarge,
                color = Dblue
            )
        }
    }





}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen(rememberNavController())
}

package com.tracey.vaulthaven.ui.screens.utilities

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.CurrencyExchange
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material.icons.filled.Subscriptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tracey.vaulthaven.navigation.ROUT_HOME
import com.tracey.vaulthaven.navigation.ROUT_PROFILE
import com.tracey.vaulthaven.navigation.ROUT_TRANSACTIONS
import com.tracey.vaulthaven.ui.theme.Bblue
import com.tracey.vaulthaven.ui.theme.Dblue

//Add a dashboard and a card
//in those cards include extra info on the app


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UtilitiesScreen(navController: NavController){

    //Scaffold

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        //TopBar
        topBar = {
            TopAppBar(
                title = { Text("Utilities", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Dblue)
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
                    label = { Text("Transactions", color = Color.White) },
                    selected = selectedIndex == 3,
                    onClick = { selectedIndex = 3
                        // navController.navigate(ROUT_HOME)
                        navController.navigate(ROUT_TRANSACTIONS)

                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Bblue
                    )
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.AccountCircle, contentDescription = "",tint = Color.White) },
                    label = { Text("Profile", color = Color.White) },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2
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
                    selected = selectedIndex == 0,
                    onClick = { selectedIndex = 0
                        //  navController.navigate(ROUT_HOME)
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

                ) {

                Spacer(modifier = Modifier.height(20.dp))

                // Bill Payments
                CardSection(
                    title = "Bill Payments",
                    description = "Quickly pay electricity, water, and more",
                    icon = Icons.Default.Payment,
                    color = Dblue
                )

                Spacer(modifier = Modifier.height(20.dp))


                // Currency Converter
                CardSection(
                    title = "Currency Converter",
                    description = "Convert between currencies in real-time",
                    icon = Icons.Default.CurrencyExchange,
                    color = Dblue
                )

                Spacer(modifier = Modifier.height(20.dp))



                // Loan Calculator
                CardSection(
                    title = "Loan Calculator",
                    description = "Estimate loan repayments",
                    icon = Icons.Default.Calculate,
                    color = Dblue
                )

                Spacer(modifier = Modifier.height(20.dp))



                // Split Bill
                CardSection(
                    title = "Split Bill",
                    description = "Easily divide costs with friends",
                    icon = Icons.Default.Group,
                    color = Dblue
                )
                Spacer(modifier = Modifier.height(20.dp))


                // Subscription Tracker
                CardSection(
                    title = "Subscription Tracker",
                    description = "Keep track of upcoming renewals",
                    icon = Icons.Default.Subscriptions,
                    color = Dblue
                )
                Spacer(modifier = Modifier.height(20.dp))



                // Spending Insights (Mini chart placeholder)
                Card(
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(6.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text("Spending Insights", style = MaterialTheme.typography.titleMedium)
                        Text("See where your money goes", color = Color.Gray)

                        // Simple bar chart
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.Bottom
                        ) {
                            listOf(0.6f, 0.8f, 0.4f, 0.7f).forEach { value ->
                                Box(
                                    modifier = Modifier
                                        .height((value * 100).dp)
                                        .width(20.dp)
                                        .background(Dblue.copy(alpha = 0.7f), shape = RoundedCornerShape(4.dp))
                                )
                            }
                        }
                    }
                }

}


        })


}


@Composable
fun CardSection(title: String, description: String, icon: ImageVector, color: Color) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(icon, contentDescription = null, tint = color, modifier = Modifier.size(32.dp))
            Spacer(Modifier.width(12.dp))
            Column {
                Text(title, style = MaterialTheme.typography.titleMedium)
                Text(description, color = Color.Gray, fontSize = 14.sp)
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun UtilitiesScreenPreview() {
    UtilitiesScreen(rememberNavController())
}

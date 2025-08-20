package com.tracey.vaulthaven.ui.screens.transactions

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.tracey.vaulthaven.navigation.ROUT_HOME
import com.tracey.vaulthaven.navigation.ROUT_PROFILE
import com.tracey.vaulthaven.navigation.ROUT_TRANSACTIONS
import com.tracey.vaulthaven.navigation.ROUT_UTILITIES
import com.tracey.vaulthaven.ui.theme.Bblue
import com.tracey.vaulthaven.ui.theme.Dblue

// 🔹 Model for a Transaction
data class Transaction(
    val title: String,
    val time: String,
    val amount: String,
    val iconRes: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionsScreen(navController: NavController) {
    val transactions = remember {
        listOf(
            Transaction("Chicken Inn", "Today, 3:51 PM", "KSh 850", R.drawable.chckeninn),
            Transaction("Spotify", "Today, 1:38 PM", "KSh 349", R.drawable.spotify),
            Transaction("Netflix", "Today, 12:05 PM", "KSh 300", R.drawable.netflix),
            Transaction("Tracey Wanjiku", "Today, 10:31 AM", "KSh 1800", R.drawable.tlogo),
            Transaction("Outing", "Yesterday, 10:00 PM", "KSh 1,000", R.drawable.entertainment),
            Transaction("Gabriel Kihumba", "Yesterday, 10:31 AM", "KSh 430", R.drawable.glogo),
            Transaction("Food Delivery", "Yesterday, 9:15 AM", "KSh 1850", R.drawable.food),
            Transaction("Transport", "Yesterday, 7:42 PM", "KSh 300", R.drawable.transport),
            Transaction("Shopping", "Aug 18, 2:10 PM", "KSh 1,200", R.drawable.shopping),
            Transaction("Tracey Wanjiku", "Aug 18, 10:31 AM", "KSh 850", R.drawable.tlogo),
            Transaction("Transport", "Aug 16, 7:42 PM", "KSh 300", R.drawable.transport),
            Transaction("Mercy Wairimu", "Aug 16, 10:31 AM", "KSh 850", R.drawable.mlogo),
            Transaction("Netflix Subscription", "Aug 15, 10:00 PM", "KSh 1,000", R.drawable.entertainment),
            Transaction("Transport", "Aug 14, 7:42 PM", "KSh 300", R.drawable.transport),
            Transaction("Groceries", "Aug 12, 6:23 PM", "KSh 4,500", R.drawable.groceries),
            Transaction("Wahome Mike", "Aug 12, 10:31 AM", "KSh 150", R.drawable.wlogo),
            Transaction("Tracey Wanjiku", "Aug 12, 11:31 pM", "KSh 850", R.drawable.tlogo),
            Transaction("Jaimie Awuor", "Aug 12, 10:31 AM", "KSh 3650", R.drawable.jlogo),
            Transaction("Transport", "Aug 9, 10:31 AM", "KSh 850", R.drawable.transport),
            Transaction("Shopping", "Aug 8, 6:35 AM", "KSh 3537", R.drawable.shopping),
            Transaction("Outing", "Aug 7, 5:29 pM", "KSh 1588", R.drawable.entertainment),
            Transaction("Sharlton Maina", "Aug 1, 10:31 PM", "KSh 850", R.drawable.slogo),

        )
    }

    var selectedIndex by remember { mutableStateOf(0) }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Hi Tracey,") },


                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Dblue,
                    titleContentColor = Color.White
                )
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
                    selected = selectedIndex == 5,
                    onClick = { selectedIndex = 5
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
                    selected = selectedIndex == 0,
                    onClick = { selectedIndex = 0
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
                    selected = selectedIndex == 5,
                    onClick = { selectedIndex = 5
                        // navController.navigate(ROUT_HOME)
                        navController.navigate(ROUT_BUDGET)

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



        ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // 🔹 Balance Card at the top
            Card(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                elevation = CardDefaults.elevatedCardElevation(5.dp),
                colors = CardDefaults.cardColors(Dblue),
                shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    //card
                    Card(onClick = {},
                        modifier = Modifier.fillMaxWidth().height(150.dp).padding(start = 20.dp, end = 20.dp, bottom = 10.dp),
                        elevation = CardDefaults.elevatedCardElevation(5.dp),
                        //colors = CardDefaults.cardColors(Teal)
                        colors = CardDefaults.cardColors((Color(0xFFF8F8F8)))
                    ) {
                        Column(

                        ) {

                            Text(
                                text = " Account balance ",
                                fontSize = 18.sp,
                                modifier = Modifier.padding(start = 80.dp, top = 20.dp),
                                color = Color.Black


                            )
                            Spacer(modifier = Modifier.height(5.dp))

                            Text(
                                text = "ksh 54378.60",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 90.dp),
                                color = Color.Black


                            )
                            Spacer(modifier = Modifier.height(20.dp))

                            Row(
                                modifier = Modifier.align(Alignment.CenterHorizontally).padding(start = 80.dp)

                            ) {

                                Column {
                                    Text(
                                        text = "Number",
                                        fontSize = 15.sp,
                                        color = Color.Black

                                    )
                                    Text(
                                        text = "****2415",
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black


                                    )

                                }

                                Spacer(modifier = Modifier.width(20.dp))

                                Column() {
                                    Text(
                                        text = "Exp",
                                        fontSize = 15.sp,
                                        color = Color.Black

                                    )
                                    Text(
                                        text = "12/30",
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black,

                                        )

                                }



                            }




                        }


                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 🔹 Transaction History
            Text(
                text = "Transaction History",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            //Search bar
            var search by remember { mutableStateOf("") }
            OutlinedTextField(
                value = search,
                onValueChange = {search = it},
                modifier = Modifier.fillMaxWidth().padding(start = 20.dp , end = 20.dp),
                leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "search") },
                placeholder = { Text(text = "Search Transactions ") },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Dblue,
                    focusedBorderColor = Dblue
                )
            )


            //End of search bar
            Spacer(modifier = Modifier.height(10.dp))


            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(transactions) { transaction ->
                    TransactionRow(transaction)
                }
            }
        }
    }
}

// 🔹 Reusable Transaction Row
@Composable
fun TransactionRow(transaction: Transaction) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(transaction.iconRes),
                contentDescription = transaction.title,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(transaction.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(transaction.time, fontSize = 14.sp, color = Color.Gray)
            }
        }

        Text(
            transaction.amount,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TransactionsScreenPreview() {
    TransactionsScreen(navController = rememberNavController())
}

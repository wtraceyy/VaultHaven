package com.tracey.vaulthaven.ui.screens.transactions

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.graphics.RectangleShape
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

//ability to add new transactions linked to an account
//A transaction includes :
                         // amount (positive for income , negative for expenses)
                         // category (food , transport ,bills,entertainment)
                         //type (income or expense)
                         //date and time
//Transactions should update the account balance automatically

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionsScreen(navController: NavController){

    //Scaffold

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        //TopBar
        topBar = {


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


        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),

            ) {
                //card
                Card(onClick = {},
                    modifier = Modifier.fillMaxWidth().height(250.dp),
                    elevation = CardDefaults.elevatedCardElevation(5.dp),
                    colors = CardDefaults.cardColors(Dblue),
                    shape = RectangleShape
                ) {
                    Row {
                        Image(
                            painter = painterResource(R.drawable.hello),
                            contentDescription = "shoe",
                            modifier = Modifier.width(50.dp).height(50.dp)
                                .padding(top = 5.dp),
                        )
                        Spacer(modifier = Modifier.width(5.dp))

                        Column {
                            Text(
                                text = "Hi,",
                                fontSize = 18.sp,
                                modifier = Modifier.padding(start = 10.dp, top = 5.dp),
                                color = Color.White

                            )

                            Spacer(modifier = Modifier.height(3.dp))

                            Text(
                                text = "Tracey",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 10.dp),
                                color = Color.White

                            )

                        }

                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Column {
                        Text(
                            text = "Balance",
                            fontSize = 18.sp,
                            modifier = Modifier.padding(start = 150.dp, top = 5.dp),
                            color = Color.White

                        )

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(
                            text = "ksh.54378",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 150.dp),
                            color = Color.White

                        )

                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                       horizontalArrangement = Arrangement.Center

                    ) {
                        Card(
                            onClick = {},
                            modifier = Modifier.width(170.dp).height(40.dp),
                            elevation = CardDefaults.elevatedCardElevation(5.dp),
                            colors = CardDefaults.cardColors((Color(0xFFF8F8F8))),


                        ) {
                            Row(
                                modifier = Modifier.padding(top = 10.dp, start = 10.dp)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.plus),
                                    contentDescription = "shoe",
                                    modifier = Modifier.width(20.dp).height(20.dp).padding(top = 5.dp),
                                )

                                Spacer(modifier = Modifier.width(5.dp))



                                Text(
                                    text = "Add Money",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black

                                )



                            }


                        }
                        Spacer(modifier = Modifier.width(15.dp))

                        Card(
                            onClick = {},
                            modifier = Modifier.width(170.dp).height(40.dp),
                            elevation = CardDefaults.elevatedCardElevation(5.dp),
                            colors = CardDefaults.cardColors((Color(0xFFF8F8F8))),


                            ) {
                            Row(
                                modifier = Modifier.padding(top = 10.dp, start = 10.dp)

                            ) {
                                Image(
                                    painter = painterResource(R.drawable.arrow),
                                    contentDescription = "shoe",
                                    modifier = Modifier.width(25.dp).height(25.dp),
                                )

                                Spacer(modifier = Modifier.width(5.dp))



                                Text(
                                    text = "Send Money",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black

                                )



                            }



                        }



                    }



                }


                Card(
                    onClick = {},
                    modifier = Modifier.fillMaxSize().offset(y = (-40).dp),
                    shape = RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp),
                    elevation = CardDefaults.elevatedCardElevation(5.dp),
                    //colors = CardDefaults.cardColors(Teal)
                    colors = CardDefaults.cardColors((Color(0xFFF8F8F8)))
                ) {
                        Text(
                            text = "Transaction History",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 10.dp, top = 5.dp),
                            color = Color.Black

                        )

                        Spacer(modifier = Modifier.height(10.dp))

                    //Search bar
                    var search by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value = search,
                        onValueChange = {search = it},
                        modifier = Modifier.fillMaxWidth().padding(start = 20.dp , end = 20.dp),
                        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "search") },
                        placeholder = { Text(text = "Search Transaction ... ") },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Dblue,
                            focusedBorderColor = Dblue

                        )
                    )
                    Spacer(modifier = Modifier.height(20.dp))


                    Column() {
                              Row(

                        ) {
                            Image(
                                painter = painterResource(R.drawable.chckeninn),
                                contentDescription = "shoe",
                                modifier = Modifier.width(25.dp).height(30.dp)
                                    .padding(top = 5.dp),
                            )
                            Spacer(modifier = Modifier.width(10.dp))

                            Column() {
                                Text(
                                    text = "Chicken Inn",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black

                                )
                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "Today, at 3:51 PM",
                                    fontSize = 15.sp,
                                    color = Color.Black

                                )

                            }
                            Spacer(modifier = Modifier.width(120.dp))

                            Text(
                                text = "ksh.790",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black

                            )


                        }
                        //
                        Spacer(modifier = Modifier.height(20.dp))

                        Row(

                        ) {
                            Image(
                                painter = painterResource(R.drawable.spotify),
                                contentDescription = "shoe",
                                modifier = Modifier.width(25.dp).height(30.dp)
                                    .padding(top = 5.dp),
                            )
                            Spacer(modifier = Modifier.width(10.dp))

                            Column() {
                                Text(
                                    text = "Spotify",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black

                                )
                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "Today, at 1:38 PM",
                                    fontSize = 15.sp,
                                    color = Color.Black

                                )

                            }
                            Spacer(modifier = Modifier.width(120.dp))

                            Text(
                                text = "ksh.349",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black

                            )


                        }
                        //
                        Spacer(modifier = Modifier.height(20.dp))

                        Row(

                        ) {
                            Image(
                                painter = painterResource(R.drawable.netflix),
                                contentDescription = "shoe",
                                modifier = Modifier.width(25.dp).height(25.dp)
                                    .padding(top = 5.dp),
                            )
                            Spacer(modifier = Modifier.width(10.dp))

                            Column() {
                                Text(
                                    text = "Netflix",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black

                                )
                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "Today, at 12:05 PM",
                                    fontSize = 15.sp,
                                    color = Color.Black

                                )

                            }
                            Spacer(modifier = Modifier.width(110.dp))

                            Text(
                                text = "ksh.300",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black

                            )


                        }
                        //
                        Spacer(modifier = Modifier.height(20.dp))

                        Row(

                        ) {
                            Image(
                                painter = painterResource(R.drawable.tlogo),
                                contentDescription = "shoe",
                                modifier = Modifier.width(25.dp).height(25.dp)
                                    .padding(top = 5.dp),
                            )
                            Spacer(modifier = Modifier.width(10.dp))

                            Column() {
                                Text(
                                    text = "Tracey Wanjiku",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black

                                )
                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "Today, at 10:31 AM",
                                    fontSize = 15.sp,
                                    color = Color.Black

                                )

                            }
                            Spacer(modifier = Modifier.width(100.dp))

                            Text(
                                text = "ksh.1800",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black

                            )


                        }
                        Spacer(modifier = Modifier.height(20.dp))

                        Row(

                        ) {
                            Image(
                                painter = painterResource(R.drawable.tlogo),
                                contentDescription = "shoe",
                                modifier = Modifier.width(25.dp).height(25.dp)
                                    .padding(top = 5.dp),
                            )
                            Spacer(modifier = Modifier.width(10.dp))

                            Column() {
                                Text(
                                    text = "Tracey Wanjiku",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black

                                )
                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "Today, at 10:31 AM",
                                    fontSize = 15.sp,
                                    color = Color.Black

                                )

                            }
                            Spacer(modifier = Modifier.width(100.dp))

                            Text(
                                text = "ksh.1800",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black

                            )


                        }
                        Spacer(modifier = Modifier.height(20.dp))

                        Row(

                        ) {
                            Image(
                                painter = painterResource(R.drawable.tlogo),
                                contentDescription = "shoe",
                                modifier = Modifier.width(25.dp).height(25.dp)
                                    .padding(top = 5.dp),
                            )
                            Spacer(modifier = Modifier.width(10.dp))

                            Column() {
                                Text(
                                    text = "Tracey Wanjiku",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black

                                )
                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "Today, at 10:31 AM",
                                    fontSize = 15.sp,
                                    color = Color.Black

                                )

                            }
                            Spacer(modifier = Modifier.width(100.dp))

                            Text(
                                text = "ksh.1800",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black

                            )


                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Row(

                        ) {
                            Image(
                                painter = painterResource(R.drawable.tlogo),
                                contentDescription = "shoe",
                                modifier = Modifier.width(25.dp).height(25.dp)
                                    .padding(top = 5.dp),
                            )
                            Spacer(modifier = Modifier.width(10.dp))

                            Column() {
                                Text(
                                    text = "Tracey Wanjiku",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black

                                )
                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "Today, at 10:31 AM",
                                    fontSize = 15.sp,
                                    color = Color.Black

                                )

                            }
                            Spacer(modifier = Modifier.width(100.dp))

                            Text(
                                text = "ksh.1800",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black

                            )


                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Row(

                        ) {
                            Image(
                                painter = painterResource(R.drawable.tlogo),
                                contentDescription = "shoe",
                                modifier = Modifier.width(25.dp).height(25.dp)
                                    .padding(top = 5.dp),
                            )
                            Spacer(modifier = Modifier.width(10.dp))

                            Column() {
                                Text(
                                    text = "Tracey Wanjiku",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black

                                )
                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "Today, at 10:31 AM",
                                    fontSize = 15.sp,
                                    color = Color.Black

                                )

                            }
                            Spacer(modifier = Modifier.width(100.dp))

                            Text(
                                text = "ksh.1800",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black

                            )


                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Row(

                        ) {
                            Image(
                                painter = painterResource(R.drawable.tlogo),
                                contentDescription = "shoe",
                                modifier = Modifier.width(25.dp).height(25.dp)
                                    .padding(top = 5.dp),
                            )
                            Spacer(modifier = Modifier.width(10.dp))

                            Column() {
                                Text(
                                    text = "Tracey Wanjiku",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black

                                )
                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "Today, at 10:31 AM",
                                    fontSize = 15.sp,
                                    color = Color.Black

                                )

                            }
                            Spacer(modifier = Modifier.width(100.dp))

                            Text(
                                text = "ksh.1800",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black

                            )


                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Row(

                        ) {
                            Image(
                                painter = painterResource(R.drawable.tlogo),
                                contentDescription = "shoe",
                                modifier = Modifier.width(25.dp).height(25.dp)
                                    .padding(top = 5.dp),
                            )
                            Spacer(modifier = Modifier.width(10.dp))

                            Column() {
                                Text(
                                    text = "Tracey Wanjiku",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black

                                )
                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "Today, at 10:31 AM",
                                    fontSize = 15.sp,
                                    color = Color.Black

                                )

                            }
                            Spacer(modifier = Modifier.width(100.dp))

                            Text(
                                text = "ksh.1800",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black

                            )


                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Row(

                        ) {
                            Image(
                                painter = painterResource(R.drawable.tlogo),
                                contentDescription = "shoe",
                                modifier = Modifier.width(25.dp).height(25.dp)
                                    .padding(top = 5.dp),
                            )
                            Spacer(modifier = Modifier.width(10.dp))

                            Column() {
                                Text(
                                    text = "Tracey Wanjiku",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black

                                )
                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "Today, at 10:31 AM",
                                    fontSize = 15.sp,
                                    color = Color.Black

                                )

                            }
                            Spacer(modifier = Modifier.width(100.dp))

                            Text(
                                text = "ksh.1800",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black

                            )


                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Row(

                        ) {
                            Image(
                                painter = painterResource(R.drawable.tlogo),
                                contentDescription = "shoe",
                                modifier = Modifier.width(25.dp).height(25.dp)
                                    .padding(top = 5.dp),
                            )
                            Spacer(modifier = Modifier.width(10.dp))

                            Column() {
                                Text(
                                    text = "Tracey Wanjiku",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black

                                )
                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "Today, at 10:31 AM",
                                    fontSize = 15.sp,
                                    color = Color.Black

                                )

                            }
                            Spacer(modifier = Modifier.width(100.dp))

                            Text(
                                text = "ksh.1800",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black

                            )


                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Row(

                        ) {
                            Image(
                                painter = painterResource(R.drawable.tlogo),
                                contentDescription = "shoe",
                                modifier = Modifier.width(25.dp).height(25.dp)
                                    .padding(top = 5.dp),
                            )
                            Spacer(modifier = Modifier.width(10.dp))

                            Column() {
                                Text(
                                    text = "Tracey Wanjiku",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black

                                )
                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "Today, at 10:31 AM",
                                    fontSize = 15.sp,
                                    color = Color.Black

                                )

                            }
                            Spacer(modifier = Modifier.width(100.dp))

                            Text(
                                text = "ksh.1800",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black

                            )


                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Row(

                        ) {
                            Image(
                                painter = painterResource(R.drawable.tlogo),
                                contentDescription = "shoe",
                                modifier = Modifier.width(25.dp).height(25.dp)
                                    .padding(top = 5.dp),
                            )
                            Spacer(modifier = Modifier.width(10.dp))

                            Column() {
                                Text(
                                    text = "Tracey Wanjiku",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black

                                )
                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "Today, at 10:31 AM",
                                    fontSize = 15.sp,
                                    color = Color.Black

                                )

                            }
                            Spacer(modifier = Modifier.width(100.dp))

                            Text(
                                text = "ksh.1800",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black

                            )


                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Row(

                        ) {
                            Image(
                                painter = painterResource(R.drawable.tlogo),
                                contentDescription = "shoe",
                                modifier = Modifier.width(25.dp).height(25.dp)
                                    .padding(top = 5.dp),
                            )
                            Spacer(modifier = Modifier.width(10.dp))

                            Column() {
                                Text(
                                    text = "Tracey Wanjiku",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black

                                )
                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "Today, at 10:31 AM",
                                    fontSize = 15.sp,
                                    color = Color.Black

                                )

                            }
                            Spacer(modifier = Modifier.width(100.dp))

                            Text(
                                text = "ksh.1800",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black

                            )


                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Row(

                        ) {
                            Image(
                                painter = painterResource(R.drawable.tlogo),
                                contentDescription = "shoe",
                                modifier = Modifier.width(25.dp).height(25.dp)
                                    .padding(top = 5.dp),
                            )
                            Spacer(modifier = Modifier.width(10.dp))

                            Column() {
                                Text(
                                    text = "Tracey Wanjiku",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black

                                )
                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "Today, at 10:31 AM",
                                    fontSize = 15.sp,
                                    color = Color.Black

                                )

                            }
                            Spacer(modifier = Modifier.width(100.dp))

                            Text(
                                text = "ksh.1800",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black

                            )


                        }//end of trnasaction row




                    }

                }

















                    }//MAIN COLUMN
        }//CONTENT
    )

    //End of scaffold



}

@Preview(showBackground = true)
@Composable
fun TransactionsScreenPreview() {
    TransactionsScreen(rememberNavController())
}
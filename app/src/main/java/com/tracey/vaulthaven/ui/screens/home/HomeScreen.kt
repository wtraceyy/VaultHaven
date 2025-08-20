package com.tracey.vaulthaven.ui.screens.home

import android.app.Notification
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tracey.vaulthaven.R
import com.tracey.vaulthaven.navigation.ROUT_ABOUT
import com.tracey.vaulthaven.navigation.ROUT_BUDGET
import com.tracey.vaulthaven.navigation.ROUT_DASHBOARD
import com.tracey.vaulthaven.navigation.ROUT_HOME
import com.tracey.vaulthaven.navigation.ROUT_LOGIN
import com.tracey.vaulthaven.navigation.ROUT_PROFILE
import com.tracey.vaulthaven.navigation.ROUT_TRANSACTIONS
import com.tracey.vaulthaven.navigation.ROUT_UTILITIES
import com.tracey.vaulthaven.ui.theme.Bblue
import com.tracey.vaulthaven.ui.theme.Dblue
import com.tracey.vaulthaven.ui.theme.whiter

//Create a show balance

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){

    //Scaffold

   var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        //TopBar
        topBar = {
            TopAppBar(
                title = { Text("Hi Tracey,") },

                colors = TopAppBarDefaults.topAppBarColors(
                    titleContentColor = Color.White,
                    navigationIconContentColor =Color.White,
                    actionIconContentColor = Color.White,
                    containerColor = Dblue


                ),
                actions = {
                    IconButton(onClick = {
                        navController.navigate(ROUT_DASHBOARD)
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
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
                    selected = selectedIndex == 0,
                    onClick = { selectedIndex = 0
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
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1
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

        //FloatingActionButton
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Add action */
                    navController.navigate(ROUT_DASHBOARD)
                },
                containerColor = Dblue,
                shape = CircleShape,

            ) {
                Icon(Icons.Default.Add, contentDescription = "Add" , tint = Color.White)
            }
        },


        //Main Contents of the page
        content = { paddingValues ->

            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {

                //row
                Row(


                ) {
                    //card
                    Card(onClick = {},
                        modifier = Modifier.fillMaxWidth().height(150.dp).padding(start = 20.dp, end = 20.dp),
                        elevation = CardDefaults.elevatedCardElevation(5.dp),
                        //colors = CardDefaults.cardColors(Teal)
                        colors = CardDefaults.cardColors(Color.Transparent)
                    ) {
                        Column(

                        ) {

                            Text(
                                text = " Account balance ",
                                fontSize = 18.sp,
                                modifier = Modifier.padding(start = 90.dp, top = 20.dp),
                                color = Color.Black


                            )
                            Spacer(modifier = Modifier.height(5.dp))

                            Text(
                                text = "ksh 54378.60",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 100.dp),
                                color = Color.Black


                            )
                            Spacer(modifier = Modifier.height(20.dp))

                            Row(
                                modifier = Modifier.align(Alignment.CenterHorizontally).padding(start = 90.dp)

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
                    Spacer(modifier = Modifier.height(20.dp))

                //Icon row
                Row(
                    modifier = Modifier
                        .horizontalScroll(rememberScrollState())

                ) {
                    Column {
                        //card
                        Card(onClick = {},
                            modifier = Modifier.width(120.dp).height(70.dp).padding(start = 20.dp, end = 20.dp),
                            elevation = CardDefaults.elevatedCardElevation(5.dp),
                            //colors = CardDefaults.cardColors(Teal)
                            colors = CardDefaults.cardColors(Bblue)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.send),
                                contentDescription = "shoe",
                                modifier = Modifier.width(80.dp).height(50.dp).padding(start = 10.dp , end = 10.dp,top = 10.dp),
                            )
                            Spacer(modifier = Modifier.width(3.dp))


                        }
                        Text(
                            text = " Send",
                            fontSize = 15.sp,
                            modifier = Modifier.padding(start = 25.dp, top = 10.dp),
                            color = Color.Black

                        )

                    }


                    //card
                    Column {
                        Card(onClick = {},
                            modifier = Modifier.width(120.dp).height(70.dp).padding(start = 20.dp, end = 20.dp),
                            elevation = CardDefaults.elevatedCardElevation(5.dp),
                            //colors = CardDefaults.cardColors(Teal)
                            colors = CardDefaults.cardColors(Dblue)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.withdraws),
                                contentDescription = "shoe",
                                modifier = Modifier.width(80.dp).height(50.dp).padding(start = 10.dp , end = 10.dp,top = 10.dp),

                                )
                            Spacer(modifier = Modifier.width(3.dp))


                        }
                        Text(
                            text = "Withdraw",
                            fontSize = 15.sp,
                            modifier = Modifier.padding(start = 25.dp, top = 10.dp),
                            color = Color.Black

                        )

                    }

                    //card
                    Column {
                        Card(onClick = {},
                            modifier = Modifier.width(120.dp).height(70.dp).padding(start = 20.dp, end = 20.dp),
                            elevation = CardDefaults.elevatedCardElevation(5.dp),
                            //colors = CardDefaults.cardColors(Teal)
                            colors = CardDefaults.cardColors(Bblue)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.topup),
                                contentDescription = "shoe",
                                modifier = Modifier.width(80.dp).height(50.dp).padding(start = 10.dp , end = 10.dp, top = 10.dp),

                                )
                            Spacer(modifier = Modifier.width(3.dp))


                        }
                        Text(
                            text = "Top up",
                            fontSize = 15.sp,
                            modifier = Modifier.padding(start = 25.dp, top = 10.dp),
                            color = Color.Black

                        )

                    }

                    //card
                    Column {
                        Card(onClick = {},
                            modifier = Modifier.width(120.dp).height(70.dp).padding(start = 20.dp, end = 20.dp),
                            elevation = CardDefaults.elevatedCardElevation(5.dp),
                            //colors = CardDefaults.cardColors(Teal)
                            colors = CardDefaults.cardColors(Dblue)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.pay),
                                contentDescription = "shoe",
                                modifier = Modifier.width(80.dp).height(80.dp).padding(start = 10.dp , end = 10.dp,top = 10.dp ),
                            )

                        }
                        Text(
                            text = "Pay",
                            fontSize = 15.sp,
                            modifier = Modifier.padding(start = 25.dp, top = 10.dp),
                            color = Color.Black

                        )

                    }

                }
                //end of icon row

                Spacer(modifier = Modifier.height(20.dp))

                Column() {

                    Card(onClick = {},
                        modifier = Modifier.fillMaxWidth().height(100.dp).padding(start = 20.dp, end = 20.dp),
                        elevation = CardDefaults.elevatedCardElevation(5.dp),
                        //colors = CardDefaults.cardColors(Teal)
                        colors = CardDefaults.cardColors(Dblue)
                    ) {

                        Row(
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                                .padding(top = 20.dp),
                            verticalAlignment = Alignment.CenterVertically

                        ) {

                            Column {
                                Row {
                                    Image(
                                        painter = painterResource(R.drawable.greendot),
                                        contentDescription = "shoe",
                                        modifier = Modifier.width(25.dp).height(25.dp)
                                            .padding(top = 5.dp),
                                    )


                                    Text(
                                        text = "Earned",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White

                                    )
                                }

                                Text(
                                    text = "ksh 75000",
                                    fontSize = 20.sp,
                                    color = Color.White


                                )

                            }

                            Spacer(modifier = Modifier.width(40.dp))

                            Column() {
                                Row {

                                    Image(
                                        painter = painterResource(R.drawable.reddot),
                                        contentDescription = "shoe",
                                        modifier = Modifier.width(25.dp).height(25.dp)
                                            .padding(top = 5.dp),
                                    )

                                    Text(
                                        text = "Spent",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,

                                        color = Color.White

                                    )
                                }

                                Text(
                                    text = " ksh 20622",
                                    fontSize = 20.sp,
                                    color = Color.White,

                                    )

                            }

                        } //end of earned spent
                    }

                        Spacer(modifier = Modifier.height(20.dp))

                            Card(
                                onClick = {},
                                modifier = Modifier.fillMaxSize(),
                                elevation = CardDefaults.elevatedCardElevation(5.dp),
                                //colors = CardDefaults.cardColors(Teal)
                                colors = CardDefaults.cardColors((Color(0xFFF8F8F8))),
                                shape = RectangleShape

                            ) {
                                Row(

                                ) {
                                    Text(
                                        text = "Recent Activity",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 10.dp, top = 5.dp),
                                        color = Color.Black

                                    )

                                    Spacer(modifier = Modifier.width(100.dp))

                                    TextButton(onClick = { navController.navigate(ROUT_TRANSACTIONS) }) {
                                        Text("See All", color = Color.Black,fontWeight = FontWeight.Bold, fontSize = 15.sp,)
                                    }

                                }
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




                                }//end of recent actvity


                            }











                    }










                }//main column

        })
}


    //End of scaffold

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}



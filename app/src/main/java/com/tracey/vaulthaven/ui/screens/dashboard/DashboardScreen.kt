package com.tracey.vaulthaven.ui.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tracey.vaulthaven.R
import com.tracey.vaulthaven.navigation.ROUT_HOME
import com.tracey.vaulthaven.navigation.ROUT_TRANSACTIONS
import com.tracey.vaulthaven.ui.theme.Bblue
import com.tracey.vaulthaven.ui.theme.Dblue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController){

    var selectedIndex by remember { mutableStateOf(0) }


    Scaffold(
        //TopBar
        topBar = {
            TopAppBar(
                title = { Text("DASHBOARD", color = Color.White ) },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Dblue,
                    titleContentColor = androidx.compose.ui.graphics.Color.Black,
                    navigationIconContentColor = androidx.compose.ui.graphics.Color.White,
                    actionIconContentColor = Color.White,

                ),
                        actions = {
                    IconButton(onClick = {navController.navigate(ROUT_HOME)}) {
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
                    label = { Text("Transactions", color = Color.White) },
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
                    icon = { Icon(Icons.Default.AccountCircle, contentDescription = "",tint = Color.White) },
                    label = { Text("Profile", color = Color.White) },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2
                        //  navController.navigate(ROUT_HOME)
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
            ) {
                //Main Contents of the page
                Card(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth().height(300.dp).padding(20.dp),
                    elevation = CardDefaults.elevatedCardElevation(5.dp),
                    //colors = CardDefaults.cardColors(Teal)
                    colors = CardDefaults.cardColors(Bblue)

                ) {
                    Column(

                    ) {

                        Text(
                            text = " Account balance ",
                            fontSize = 18.sp,
                            modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                            color = Color.Black


                        )
                        Spacer(modifier = Modifier.height(5.dp))

                        Text(
                            text = "ksh 54378.60",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 15.dp),
                            color = Color.Black


                        )
                        Spacer(modifier = Modifier.height(5.dp))

                        Image(
                            painter = painterResource(R.drawable.piechart),
                            contentDescription = "shoe",
                            modifier = Modifier.width(300.dp).height(250.dp)
                                .padding(start = 50.dp, end = 40.dp,
                            ),
                        )


                    }


                }//end of first card

                //row
                Row(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp, top = 40.dp)
                        .horizontalScroll(rememberScrollState())

                ) {
                    //card
                    Card(
                        onClick = {},
                        modifier = Modifier.width(200.dp).height(300.dp),
                        elevation = CardDefaults.elevatedCardElevation(5.dp),
                        //colors = CardDefaults.cardColors(Teal)
                        colors = CardDefaults.cardColors(Bblue)
                    ) {
                        Column(

                        ) {
                            Image(
                                painter = painterResource(R.drawable.topup),
                                contentDescription = "shoe",
                                modifier = Modifier.fillMaxWidth().height(150.dp).padding(
                                    start = 10.dp,
                                    end = 40.dp,
                                    top = 60.dp,
                                    bottom = 20.dp
                                ),
                            )

                            Text(
                                text = " Cryptocurrency landing page ",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 20.dp)

                            )
                            Spacer(modifier = Modifier.height(10.dp))


                            Text(
                                text = "12 likes",
                                fontSize = 15.sp,
                                modifier = Modifier.padding(start = 20.dp)

                            )


                        }


                    }


                    //end of card
                    Spacer(modifier = Modifier.width(20.dp))

                    //card
                    Card(
                        onClick = {},
                        modifier = Modifier.width(200.dp).height(300.dp),
                        elevation = CardDefaults.elevatedCardElevation(5.dp),
                        //colors = CardDefaults.cardColors(Teal)
                        colors = CardDefaults.cardColors(Bblue)

                    ) {
                        Column(

                        ) {
                            Image(
                                painter = painterResource(R.drawable.download),
                                contentDescription = "shoe",
                                modifier = Modifier.fillMaxWidth().height(150.dp).padding(
                                    start = 10.dp,
                                    end = 40.dp,
                                    top = 60.dp,
                                    bottom = 20.dp
                                ),
                            )

                            Text(
                                text = " Statistics Dashboard ",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 20.dp)

                            )
                            Spacer(modifier = Modifier.height(20.dp))


                            Text(
                                text = "12 likes ",
                                fontSize = 15.sp,
                                modifier = Modifier.padding(start = 20.dp)

                            )


                        }


                    }

                    //end of card
                    Spacer(modifier = Modifier.width(20.dp))

                    //card
                    Card(
                        onClick = {},
                        modifier = Modifier.width(200.dp).height(300.dp),
                        elevation = CardDefaults.elevatedCardElevation(5.dp),
                        //colors = CardDefaults.cardColors(Teal)
                        colors = CardDefaults.cardColors(Bblue)

                    ) {
                        Column(

                        ) {
                            Image(
                                painter = painterResource(R.drawable.netflix),
                                contentDescription = "shoe",
                                modifier = Modifier.fillMaxWidth().height(150.dp).padding(
                                    start = 10.dp,
                                    end = 40.dp,
                                    top = 60.dp,
                                    bottom = 20.dp
                                ),
                            )

                            Text(
                                text = " Statistics Dashboard ",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 20.dp)

                            )


                        }//end of last column
                    } //end of last card'
                }//end of main row w dashboards
            }//end of main column
        }//end of content







    )//End of scaffold

  }

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen(rememberNavController())
}

package com.tracey.vaulthaven.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tracey.vaulthaven.data.UserDatabase
import com.tracey.vaulthaven.repository.UserRepository
import com.tracey.vaulthaven.ui.screens.about.AboutScreen
import com.tracey.vaulthaven.ui.screens.auth.LoginScreen
import com.tracey.vaulthaven.ui.screens.auth.RegisterScreen
import com.tracey.vaulthaven.ui.screens.budget.BudgetScreen
import com.tracey.vaulthaven.ui.screens.dashboard.DashboardScreen
import com.tracey.vaulthaven.ui.screens.home.HomeScreen
import com.tracey.vaulthaven.ui.screens.profile.ProfileScreen
import com.tracey.vaulthaven.ui.screens.splash.SplashScreen
import com.tracey.vaulthaven.ui.screens.transactions.TransactionsScreen
import com.tracey.vaulthaven.ui.screens.utilities.UtilitiesScreen
import com.tracey.vaulthaven.viewmodel.AuthViewModel


@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_SPLASH,


    ) {

    val context = LocalContext.current


    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        composable(ROUT_HOME) {
            HomeScreen(navController)
        }

        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }
        composable(ROUT_ABOUT) {
            AboutScreen(navController)
        }
        composable(ROUT_TRANSACTIONS) {
            TransactionsScreen(navController)
        }
        composable(ROUT_DASHBOARD) {
            DashboardScreen(navController)
        }
        composable(ROUT_UTILITIES) {
            UtilitiesScreen(navController)
        }
        composable(ROUT_BUDGET) {
            BudgetScreen(navController)
        }
        composable(ROUT_PROFILE) {
            ProfileScreen(navController)
        }

        // Initialize Room Database and Repository for Authentication
        val appDatabase = UserDatabase.getDatabase(context)
        val authRepository = UserRepository(appDatabase.userDao())
        val authViewModel: AuthViewModel = AuthViewModel(authRepository)
        composable(ROUT_REGISTER) {
            RegisterScreen(authViewModel, navController) {
                navController.navigate(ROUT_LOGIN) {
                    popUpTo(ROUT_REGISTER) { inclusive = true }
                }
            }
        }

        composable(ROUT_LOGIN) {
            LoginScreen(authViewModel, navController) {
                navController.navigate(ROUT_HOME) {
                    popUpTo(ROUT_LOGIN) { inclusive = true }
                }
            }
        }

        //end of auth











    }
}


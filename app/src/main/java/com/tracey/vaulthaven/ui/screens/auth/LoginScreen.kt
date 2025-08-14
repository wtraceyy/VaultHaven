package com.tracey.vaulthaven.ui.screens.auth

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tracey.vaulthaven.R
import com.tracey.vaulthaven.navigation.ROUT_DASHBOARD
import com.tracey.vaulthaven.navigation.ROUT_HOME
import com.tracey.vaulthaven.navigation.ROUT_LOGIN
import com.tracey.vaulthaven.navigation.ROUT_REGISTER
import com.tracey.vaulthaven.ui.theme.Bblue
import com.tracey.vaulthaven.ui.theme.Dark
import com.tracey.vaulthaven.ui.theme.Dblue
import com.tracey.vaulthaven.viewmodel.AuthViewModel


@Composable
fun LoginScreen(
    authViewModel: AuthViewModel,
    navController: NavController,
    onLoginSuccess: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current

    // Observe login logic
    LaunchedEffect(authViewModel) {
        authViewModel.loggedInUser = { user ->
            if (user == null) {
                Toast.makeText(context, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            } else {
                if (user.role == "Admin") {
                    navController.navigate(ROUT_DASHBOARD) {
                    }
                } else {
                    navController.navigate(ROUT_DASHBOARD) {
                    }
                }
            }
        }
    }

    // Background Image or Gradient
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors = listOf(Dblue,Bblue,Dark)
            )
            )

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.welcome),
                contentDescription = "car",
                modifier = Modifier.width(200.dp).height(150.dp),

            )

            Spacer(modifier = Modifier.height(36.dp))


            // Animated Welcome Text
            AnimatedVisibility(
                visible = true,
                enter = fadeIn(animationSpec = tween(1000)),
                exit = fadeOut(animationSpec = tween(1000))
            ) {
                Text(
                    text = "GOOD TO HAVE YOU BACK!",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(36.dp))

            // Email Input
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email", color = Color.White) },
                leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "Email Icon", tint = Color.White) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                textStyle = MaterialTheme.typography.bodyLarge.copy(color = Color.Black),
                colors = OutlinedTextFieldDefaults.colors(Dblue,
                    focusedBorderColor = Color.White,
                    cursorColor = Color.White
                )

            )

            Spacer(modifier = Modifier.height(12.dp))

            // Password Input with Show/Hide Toggle
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password", color = Color.White) },
                leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Password Icon", tint = Color.White) },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                textStyle = MaterialTheme.typography.bodyLarge.copy(color = Color.Black),
                trailingIcon = {
                    val image = if (passwordVisible) painterResource(R.drawable.passwordshow) else painterResource(
                        R.drawable.passwordhide)
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(image, contentDescription = if (passwordVisible) "Hide Password" else "Show Password", tint = Color.White)
                    }
                },
                colors =OutlinedTextFieldDefaults.colors(Dblue,
                    focusedBorderColor = Color.White,
                    cursorColor = Color.White)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Gradient Login Button
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Dblue, Bblue, Dark)
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                        if (email.isBlank() || password.isBlank()) {
                            Toast.makeText(context, "Please enter email and password", Toast.LENGTH_SHORT).show()
                        } else {
                            authViewModel.loginUser(email, password)
                        }
                        navController.navigate(ROUT_HOME)
                    },
                    modifier = Modifier.fillMaxSize(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Login", color = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Register Navigation Button
            TextButton(onClick = { navController.navigate(ROUT_REGISTER) }) {
                Text("Don't have an account? Register", color = Color.White)
            }
        }
    }
}


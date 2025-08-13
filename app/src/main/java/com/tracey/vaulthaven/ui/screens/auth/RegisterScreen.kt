package com.tracey.vaulthaven.ui.screens.auth

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tracey.vaulthaven.R
import com.tracey.vaulthaven.model.User
import com.tracey.vaulthaven.navigation.ROUT_LOGIN
import com.tracey.vaulthaven.ui.theme.Bblue
import com.tracey.vaulthaven.ui.theme.Dark
import com.tracey.vaulthaven.ui.theme.Dblue
import com.tracey.vaulthaven.viewmodel.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    authViewModel: AuthViewModel,
    navController: NavController,
    onRegisterSuccess: () -> Unit
) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val animatedAlpha by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(durationMillis = 1500, easing = LinearEasing),
        label = "Animated Alpha"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors = listOf(Dblue,Bblue,Dark))),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        AnimatedVisibility(visible = true, enter = fadeIn(), exit = fadeOut()) {
            Text(
                "CREATE NEW ACCOUNT",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,

            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        //Username
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username", color = Color.White) },
            leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "Username Icon", tint = Color.White) },
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp),
            shape = RoundedCornerShape(12.dp),
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = Color.Black),
            colors = OutlinedTextFieldDefaults.colors(Bblue,
                focusedBorderColor = Color.White,
                cursorColor = Color.White)

        )
        //End of username


        Spacer(modifier = Modifier.height(8.dp))

        //Email
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email", color = Color.White) },
            leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "Email Icon", tint = Color.White) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp),
            shape = RoundedCornerShape(12.dp),
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = Color.Black),
            colors = OutlinedTextFieldDefaults.colors(Bblue,
                focusedBorderColor = Color.White,
                cursorColor = Color.White)
        )
        //End of email

        Spacer(modifier = Modifier.height(8.dp))


        //Role
        var role by remember { mutableStateOf("student") }
        val roleOptions = listOf("Buyer", "Seller")
        var expanded by remember { mutableStateOf(false) }

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                value = role,
                onValueChange = {},
                readOnly = true,
                label = { Text("Select Role", color = Color.White) },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor().fillMaxWidth().padding(start = 16.dp, end = 16.dp),
                shape = RoundedCornerShape(12.dp),
                textStyle = MaterialTheme.typography.bodyLarge.copy(color = Color.Black),
                colors = OutlinedTextFieldDefaults.colors(Bblue,
                    focusedBorderColor = Color.White,
                    cursorColor = Color.White)

            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                roleOptions.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(selectionOption) },
                        onClick = {
                            role = selectionOption
                            expanded = false
                        }
                    )
                }
            }
        }
        //End of role


        // Password Input Field with Show/Hide Toggle
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password", color = Color.White) },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Password Icon", tint = Color.White) },
            trailingIcon = {
                val image =
                    if (passwordVisible) painterResource(R.drawable.passwordshow) else painterResource(
                        R.drawable.passwordhide
                    )
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        image,
                        contentDescription = if (passwordVisible) "Hide Password" else "Show Password"
                        , tint = Color.White)
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp),
            shape = RoundedCornerShape(12.dp),
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = Color.Black),
            colors = OutlinedTextFieldDefaults.colors(Bblue,
                focusedBorderColor = Color.White,
                cursorColor = Color.White)

        )

        Spacer(modifier = Modifier.height(8.dp))

        // Confirm Password Input Field with Show/Hide Toggle
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password", color = Color.White) },
            visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Confirm Password Icon", tint = Color.White) },
            trailingIcon = {
                val image =
                    if (confirmPasswordVisible) painterResource(R.drawable.passwordshow) else painterResource(
                        R.drawable.passwordhide
                    )
                IconButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
                    Icon(
                        image,
                        contentDescription = if (confirmPasswordVisible) "Hide Password" else "Show Password"
                        , tint = Color.White )
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp),
            shape = RoundedCornerShape(12.dp),
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = Color.Black),
            colors = OutlinedTextFieldDefaults.colors(Bblue,
                focusedBorderColor = Color.White,
                cursorColor = Color.White)

        )

        Spacer(modifier = Modifier.height(16.dp))


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 16.dp, end = 16.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf( Dblue, Bblue,Dark)
                    ),
                    shape = MaterialTheme.shapes.medium
                ),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                    if (username.isBlank() || email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
                        Toast.makeText(context, "All fields are required", Toast.LENGTH_SHORT)
                            .show()
                    } else if (password != confirmPassword) {
                        Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
                    } else {
                        authViewModel.registerUser(
                            User(
                                username = username,
                                email = email,
                                role = role,
                                password = password
                            )
                        )
                        onRegisterSuccess()
                    }
                },
                modifier = Modifier.fillMaxSize(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Text("Register", color = Color.White)


            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Register Navigation Button
        TextButton(onClick = { navController.navigate(ROUT_LOGIN) }) {
            Text("Already have an account? Log in", color = Color.White)
        }
    }

}


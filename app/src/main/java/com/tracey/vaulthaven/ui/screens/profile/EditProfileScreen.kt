package com.tracey.vaulthaven.ui.screens.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tracey.vaulthaven.R
import com.tracey.vaulthaven.navigation.ROUT_PROFILE
import com.tracey.vaulthaven.ui.theme.Bblue
import com.tracey.vaulthaven.ui.theme.Dblue


@Composable
fun EditProfileScreen(navController: NavController) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
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
                text = "Edit Profile",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 40.dp)
            )
        }

        // Profile Picture
        Box(
            modifier = Modifier
                .offset(y = -60.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .border(4.dp, Color.White, CircleShape)
                    .shadow(6.dp, CircleShape)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tlogo),
                    contentDescription = "Profile Picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(CircleShape).size(120.dp)
                )
            }
            TextButton(
                onClick = { /* Change picture */ },
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Text("Change", color =Dblue, fontSize = 14.sp)
            }
        }

        Spacer(Modifier.height(10.dp))

        // Input Fields
        EditProfileField("Full Name", "")
        EditProfileField("Email", "")
        EditProfileField("Phone Number", "")
        EditProfileField("Bio", "")

        Spacer(Modifier.height(20.dp))

        // Buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(
                onClick = { /* Save changes */navController.navigate(ROUT_PROFILE)  },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(Dblue)
            ) {
                Text("Save Changes", color = Color.White)
            }
            OutlinedButton(
                onClick = { /* Cancel */navController.navigate(ROUT_PROFILE) },
                modifier = Modifier.weight(1f),
                border = BorderStroke(1.dp, color = Dblue)
            ) {
                Text("Cancel", color = Dblue)
            }
        }

        Spacer(Modifier.height(30.dp))
    }
}

@Composable
fun EditProfileField(label: String, value: String) {
    var text by remember { mutableStateOf(value) }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Dblue,
            focusedLabelColor = Dblue,
            cursorColor = Dblue
        ),
        shape = RoundedCornerShape(12.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun EditProfileScreenPreview() {
    EditProfileScreen(rememberNavController())
}

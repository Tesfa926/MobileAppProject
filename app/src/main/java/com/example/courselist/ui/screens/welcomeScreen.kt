package com.example.courselist.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.courselist.R

@Composable
fun WelcomeScreen( onGetIn:()-> Unit) {

    // Colors
    val backgroundColor = Color(0xFFFCEFD6)
    val buttonColor = Color(0xFFF4AD08)
    val buttonPressedColor = Color(0xFFE08C00) // Slightly darker for pressed state
    val gradientStart = Color(0xFFF58808)
    val gradientEnd = Color(0xFFF4B209)

    // State for button press effect
    var isPressed by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        // Top Gradient Mask
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .zIndex(1f)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(gradientStart, gradientEnd),
                        startY = 0f,
                        endY = 300f
                    ),
                    shape = RoundedCornerShape(bottomStart = 120.dp, bottomEnd = 120.dp)
                )
        ) {
            Text(
                text = "Course List",
                color = Color.White,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                    fontSize = 18.sp
                ),
                modifier = Modifier
                    .padding(start = 24.dp, top = 32.dp)
                    .align(Alignment.TopStart)
            )
        }

        // Main Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 80.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Welcome to Third Year\n\nSoftware Engineering\n\nDepartment Course's \n\n Description",
                color = Color.Black,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                ),
                modifier = Modifier
                    .padding(bottom = 100.dp)
                    .align(Alignment.CenterHorizontally),
                lineHeight = 24.sp
            )

            // Button
            Box(
                modifier = Modifier
                    .width(180.dp)
                    .height(45.dp)
                    .shadow(4.dp, RoundedCornerShape(20.dp))
                    .background(
                        color = if (isPressed) buttonPressedColor else buttonColor,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onPress = {
                                isPressed = true
                                tryAwaitRelease()
                                isPressed = false
                            },
                            onTap = {onGetIn()}
                        )
                    },

                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Get in",
                    color = Color.Black,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    )
                )
            }
        }
    }
}



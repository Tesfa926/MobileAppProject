package com.example.courselist.ui.Components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.courselist.R
import com.example.courselist.ui.theme.CourseListTheme

@Composable
fun CourseCard(
    title: String,
    code: String,
    creditHours: String,
    prerequisites: String,
    description: String,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val rotationAngle by animateFloatAsState(targetValue = if (expanded) 180f else 0f)
    val backgroundColor = Color(0xFFFCEFD6)
    val accentColor = Color(0xFFF58B07)
    val textColor = Color.Black
    val cardShape = RoundedCornerShape(15.dp)
    val fontFamily = FontFamily(Font(R.font.montserrat_medium))
    val fontFamilyBold = FontFamily(Font(R.font.montserrat_bold))

    Box(
        modifier = modifier
            .background(backgroundColor)
    ) {
        Card(
            modifier = Modifier
                .width(325.dp)
                .heightIn(90.dp)
                .clickable { expanded = !expanded },
            shape = cardShape,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Spacer(modifier = Modifier.width(4.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Row {
                        Text(
                            text = "Title:    ",
                            color = textColor,
                            fontFamily = fontFamilyBold,
                            fontWeight = FontWeight.Bold,
                            fontSize = 10.sp
                        )
                        Text(
                            text = title,
                            color = textColor,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 8.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Row {
                        Text(
                            text = "Code:   ",
                            color = textColor,
                            fontFamily = fontFamilyBold,
                            fontWeight = FontWeight.Bold,
                            fontSize = 10.sp
                        )
                        Text(
                            text = code,
                            color = textColor,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 8.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Row {
                        Text(
                            text = "Credit Hours:   ",
                            color = textColor,
                            fontFamily = fontFamilyBold,
                            fontWeight = FontWeight.Bold,
                            fontSize = 10.sp
                        )
                        Text(
                            text = creditHours,
                            color = textColor,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 8.sp
                        )
                    }
                }
                Box {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = if (expanded) "Collapse" else "Expand",
                        tint = accentColor,
                        modifier = Modifier
                            .rotate(rotationAngle)
                            .clickable { expanded = !expanded }
                    )
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier
                            .width(300.dp)
                            .background(backgroundColor,
                                shape = RoundedCornerShape(15.dp)
                            ),
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                        ) {
                            Row {
                                Text(
                                    text = "Description:   ",
                                    color = textColor,
                                    fontFamily = fontFamilyBold,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 10.sp
                                )
                                Text(
                                    text = description,
                                    color = textColor,
                                    fontFamily = fontFamily,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 8.sp
                                )
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Row {
                                Text(
                                    text = "Prerequisites:   ",
                                    color = textColor,
                                    fontFamily = fontFamilyBold,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 10.sp
                                )
                                Text(
                                    text = prerequisites,
                                    color = textColor,
                                    fontFamily = fontFamily,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 8.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CourseCardPreview() {
    CourseListTheme { // <-- Use your app's theme composable here
        CourseCard(
            title = "Fundamentals of Electrical Circuits and Electronics",
            code = "SECT-2121",
            creditHours = "3",
            prerequisites = "None",
            description = "An introduction to the basics of electrical circuits and electronics.",
            modifier = Modifier
        )
    }
}
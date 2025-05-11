package com.example.courselist.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.courselist.R
import com.example.courselist.ui.Components.CourseCard
import com.example.courselist.ui.model.courseList
import com.example.courselist.ui.model.semesterQuote


@Composable
fun FirstSemesterScreen(onBack: () -> Unit ) {
    // Colors
    val backgroundColor = Color(0xFFFCEFD6)
    val gradientStart = Color(0xFFF58808)
    val gradientEnd = Color(0xFFF4B209)
    val fontFamily = FontFamily(Font(R.font.montserrat_medium))

    // Use the reusable courseList
    val courses = remember { courseList }

    // Search state
    var searchQuery by remember { mutableStateOf("") }
    val accentColor = Color(0xFFF58B07)
    // Filtered courses based on search (by code or title)
    val filteredCourses = remember(searchQuery, courses) {
        if (searchQuery.isEmpty()) {
            courses
        } else {
            courses.filter { course ->
                course.courseTitle.contains(searchQuery, ignoreCase = true) ||
                course.courseCode.contains(searchQuery, ignoreCase = true)
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        // Header with gradient and back arrow
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(gradientStart, gradientEnd),
                        startY = 0f,
                        endY = 300f
                    ),
                    shape = RoundedCornerShape(bottomStart = 120.dp, bottomEnd = 120.dp)
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 35.dp, start = 0.dp, end = 0.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBackIosNew,
                    contentDescription = "Back",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(28.dp)
                        .padding(start = 8.dp)
                        .clickable { onBack() }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Welcome !",
                    color = Color.White,
                    style = TextStyle(
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp
                    ),
                    modifier = Modifier.padding(start = 0.dp)
                )
            }
        }

        // Main content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp, start = 0.dp, end = 0.dp, bottom = 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Search Bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .width(325.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White),
                placeholder = { Text("Search for courses by title or code") },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint= accentColor
                    )
                },
                shape = RoundedCornerShape(12.dp),
                singleLine = true,
                textStyle = TextStyle(fontSize = 12.sp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Description placeholder
            Box(
                modifier = Modifier
                    .widthIn(325.dp)
                    .heightIn(90.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.White)
                    .padding(10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = semesterQuote,
                    color =gradientEnd,
                    fontFamily = FontFamily(Font(resId=R.font.montserrat_medium)),
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp)
            }
            Spacer(modifier = Modifier.height(16.dp))
            // Course List
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(filteredCourses) { course ->
                    CourseCard(
                        title = course.courseTitle,
                        code = course.courseCode,
                        creditHours = course.ectsPerWeek.toString(),
                        prerequisites = course.prerequisite,
                        description = course.description,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppFirstPreview() {
    FirstSemesterScreen(
        onBack = {}
    )
}
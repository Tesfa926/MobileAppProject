package com.example.courselist

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.courselist.ui.screens.FirstSemesterScreen
import com.example.courselist.ui.screens.WelcomeScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavGraph()
        }
    }
}



@Composable
fun AppNavGraph(){
    val navController = rememberNavController()
    NavHost(navController, startDestination = "welcome"){
        composable("welcome"){ WelcomeScreen(onGetIn = {navController.navigate("firstSemester")})}
        composable("firstSemester"){ FirstSemesterScreen(onBack = {navController.popBackStack()})
        }
    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AppPreview(){
AppNavGraph()
}

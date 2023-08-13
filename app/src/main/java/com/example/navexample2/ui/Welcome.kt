package com.example.navexample2.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.navexample2.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeUI(navController: NavHostController) {
    var text by remember { mutableStateOf("") }
    Scaffold(
       floatingActionButton = {
           Button(onClick = {
               navController.navigate(Screen.HomeScreen.withArgs(text))
           }) {
                Text("Next")
           }
       }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = text,
                onValueChange = { data -> text = data },
                placeholder = { Text("Enter your name") }
            )
        }
    }
}

@Preview
@Composable
fun WelcomePreview() {
    WelcomeUI(rememberNavController())
}
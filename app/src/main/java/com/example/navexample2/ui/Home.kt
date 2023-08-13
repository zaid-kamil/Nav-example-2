package com.example.navexample2.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.navexample2.Screen
import com.example.navexample2.models.Category
import com.example.navexample2.models.DataSources

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeUI(navController: NavHostController, username: String?) {
    val categories = DataSources().getCategories()
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Welcome $username", style = MaterialTheme.typography.headlineLarge
            )
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(categories.size) { index ->
                    CategoryCardUI(categories[index], index, navController)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryCardUI(category: Category, index: Int, navController: NavHostController) {
    Card(modifier = Modifier
        .height(200.dp)
        .padding(16.dp),
        onClick = {
            navController.navigate(
                Screen.DetailScreen.withArgs(index.toString())
            )
        }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(category.title),
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}


@Preview
@Composable
fun HomePreview() {
    HomeUI(rememberNavController(), username = "Alexa")
}
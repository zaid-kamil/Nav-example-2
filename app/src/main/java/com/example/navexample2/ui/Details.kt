package com.example.navexample2.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.navexample2.models.DataSources

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailUI(navController: NavHostController, index: String?) {
    val category = DataSources().getCategories()[index?.toInt() ?: 0]
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "You choose ${stringResource(category.title)}",
                style = MaterialTheme.typography.headlineLarge
            )
        }
    }
}
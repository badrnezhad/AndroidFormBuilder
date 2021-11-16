package net.holosen.androidformbuilder.ui.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@ExperimentalMaterial3Api
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(text = "New", color = Color.White) },
                onClick = { navController.navigate("addOrEdit/-1") },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            )
        },
    ) {
        NavHost(
            navController = navController,
            startDestination = "home",
        ) {
            composable("home") {

            }
            composable("addOrEdit/{id}",
                arguments = listOf(
                    navArgument("id") { type = NavType.LongType }
                )) { backStack ->
                val id = backStack.arguments?.getLong("id")!!
            }
        }
    }
}
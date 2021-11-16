package net.holosen.androidformbuilder.ui.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import net.holosen.androidformbuilder.MainActivity
import net.holosen.androidformbuilder.ui.theme.PurpleGrey40
import net.holosen.androidformbuilder.viewmodels.BodyViewModel

@ExperimentalMaterial3Api
@Composable
fun MainScreen(mainActivity: MainActivity) {
    val navController = rememberNavController()

    val bodyViewModel =
        ViewModelProvider(mainActivity).get(BodyViewModel::class.java)
    bodyViewModel.getAllData().observe(mainActivity) {
        bodyViewModel.dataList.value = it
    }

    Scaffold(
        topBar = {
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(text = "New", color = PurpleGrey40) },
                onClick = { navController.navigate("addOrEdit/-1") },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "",
                        tint = PurpleGrey40
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
                HomeScreen(bodyViewModel, navController)
            }
            composable("addOrEdit/{id}",
                arguments = listOf(
                    navArgument("id") { type = NavType.LongType }
                )) {
                //val id = backStack.arguments?.getLong("id")!!
            }
        }
    }
}
package net.holosen.androidformbuilder.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import net.holosen.androidformbuilder.ui.components.BodyItemView
import net.holosen.androidformbuilder.viewmodels.BodyViewModel

@Composable
fun HomeScreen(
    bodyViewModel: BodyViewModel,
    navController: NavController
) {
    LazyColumn(Modifier.padding(20.dp, 0.dp, 15.dp, 15.dp)) {
        items(bodyViewModel.dataList.value.size) { index ->
            val item = bodyViewModel.dataList.value[index]
            BodyItemView(item, bodyViewModel, navController)
        }
    }
}
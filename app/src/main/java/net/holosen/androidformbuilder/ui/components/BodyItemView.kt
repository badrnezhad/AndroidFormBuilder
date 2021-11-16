package net.holosen.androidformbuilder.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import net.holosen.androidformbuilder.models.Body
import net.holosen.androidformbuilder.viewmodels.BodyViewModel

@ExperimentalMaterialApi
@Composable
fun BodyItemView(item: Body, bodyViewModel: BodyViewModel, navController: NavController) {
    Card(
        onClick = {
            navController.navigate("view/${item.id}")
        }, elevation = 0.dp,
        backgroundColor = Color.Transparent
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = item.title, fontSize = 21.sp, modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {
                navController.navigate("addOrEdit/${item.id}")
            }) {
                Icon(
                    imageVector =  Icons.Outlined.Edit,
                    contentDescription = "Edit",
                    tint = Color.LightGray
                )
            }
        }
    }
}
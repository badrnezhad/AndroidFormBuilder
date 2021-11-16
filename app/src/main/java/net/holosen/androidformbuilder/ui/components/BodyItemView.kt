package net.holosen.androidformbuilder.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import net.holosen.androidformbuilder.models.Body
import net.holosen.androidformbuilder.viewmodels.BodyViewModel

@Composable
fun BodyItemView(item: Body, bodyViewModel: BodyViewModel, navController: NavController) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = item.title, fontSize = 21.sp, modifier = Modifier.weight(1f))
    }
}
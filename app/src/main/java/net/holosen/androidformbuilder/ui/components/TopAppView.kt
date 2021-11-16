package net.holosen.androidformbuilder.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun TopAppView(
    navController: NavHostController,
) {

    TopAppBar(
        elevation = 0.dp,
    ) {
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "Android Form Builder",
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier.weight(1f),
            fontWeight = FontWeight.Bold,
            fontSize = 21.sp
        )

        IconButton(onClick = { navController.navigate("about") }) {
            Icon(
                imageVector = Icons.Filled.Info,
                contentDescription = "Info",
                tint = Color.LightGray
            )
        }
    }
}
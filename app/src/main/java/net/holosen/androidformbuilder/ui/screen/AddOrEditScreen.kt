package net.holosen.androidformbuilder.ui.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import net.holosen.androidformbuilder.models.Body
import net.holosen.androidformbuilder.ui.theme.Green
import net.holosen.androidformbuilder.viewmodels.BodyViewModel


@Composable
fun AddOrEditScreen(id: Long, bodyViewModel: BodyViewModel, navController: NavController) {
    val hasData = id >= 0
    val data = if (hasData) bodyViewModel.getById(id) else null

    var title by remember { mutableStateOf(TextFieldValue(if (hasData) data!!.title else "")) }
    var titleError by remember { mutableStateOf(false) }

    var content by remember { mutableStateOf(TextFieldValue(if (hasData) data!!.content else "")) }
    var contentError by remember { mutableStateOf(false) }

    LazyColumn(Modifier.padding(25.dp)) {
        item {
            OutlinedTextField(
                value = title,
                onValueChange = {
                    title = it
                    titleError = false
                },
                label = { Text(text = "Title") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                isError = titleError,
            )
            if (titleError) {
                Text(
                    text = "Please enter title",
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
        item {
            OutlinedTextField(
                value = content,
                onValueChange = {
                    content = it
                    contentError = false
                },
                label = { Text(text = "Content") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = false,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                isError = contentError,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Green,
                    unfocusedBorderColor = Green,
                    focusedLabelColor = Green,
                    cursorColor = Green
                ),
            )
            if (contentError) {
                Text(
                    text = "Please enter content",
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }

        item {
            Button(
                onClick = {
                    if (title.text.isEmpty()) {
                        titleError = true
                    }
                    if (content.text.isEmpty()) {
                        contentError = true
                    }

                    if (titleError || contentError) {
                        return@Button
                    }
                    val body = Body(
                        if (hasData) data!!.id else null,
                        title.text,
                        content.text
                    )
                    if (hasData) {
                        bodyViewModel.update(body)
                    } else {
                        bodyViewModel.insert(body)
                    }
                    navController.popBackStack()
                },
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
            ) {
                Text(
                    text = if (hasData) "Update" else "Insert", fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}
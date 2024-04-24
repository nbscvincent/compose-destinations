package com.evangelista.composedestination

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.evangelista.composedestination.destinations.SecondScreenDestination
import com.evangelista.composedestination.destinations.ThirdScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay

@RootNavGraph(start = true)
@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun FirstScreen(
    navigator: DestinationsNavigator
) {
    var anyText by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            value = anyText,
            onValueChange = { anyText = it },
            label = { Text(text = "") },
            textStyle = TextStyle(
                color = Color.Black
            ),
            trailingIcon = {

            },
            singleLine = true,
        )

        Button(
            onClick = {
                navigator.navigate(SecondScreenDestination)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

        ) {
            Text(
                text = "Button 1",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White,
            )
        }
        Button(
            onClick = {
                if (anyText.isBlank()) {
                    // Show error message if text field is empty
                    showError = true
                } else {
                    navigator.navigate(ThirdScreenDestination(anyText))
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(
                text = "Button 2",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White,
            )
        }

        // Show Snackbar if text field is empty
        if (showError) {
            Snackbar(
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Please fill the text field")
            }
            // Reset showError after showing the error
            LaunchedEffect(showError) {
                delay(3000) // Show for 3 seconds
                showError = false
            }
        }


    }
}



package com.evangelista.composedestination

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.evangelista.composedestination.destinations.SecondScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun FirstScreen(
    navigator: DestinationsNavigator
) {
    var anyText by remember { mutableStateOf("") }


    Column (
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp),
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
                .padding(start = 25.dp, end = 25.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF5742f5)
            ),
            shape = RoundedCornerShape(10.dp),
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
                navigator.navigate(ThirdScreenDestination(anyText))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 25.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF5742f5)
            ),
            shape = RoundedCornerShape(10.dp),
        ) {
            Text(
                text = "Button 2",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White,
            )
        }


    }
}



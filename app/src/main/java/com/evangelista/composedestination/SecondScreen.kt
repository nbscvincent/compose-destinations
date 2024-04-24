package com.evangelista.composedestination

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.evangelista.composedestination.destinations.FirstScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.Date

@SuppressLint("SimpleDateFormat")
@Destination
@Composable
fun SecondScreen(
    navigator: DestinationsNavigator
) {
    val currentTime = remember { mutableStateOf("") }

    LaunchedEffect(key1 = Unit) {
        while (true) {
            currentTime.value = SimpleDateFormat("dd/MM/yyyy hh:mm:ss a").format(Date())
            delay(1000)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Current Date & Time:")
        Spacer(modifier = Modifier.height(8.dp))
        Text(currentTime.value)

        Button(
            onClick = {
                navigator.navigate(FirstScreenDestination)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

        ) {
            Text(
                text = "Back",
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
        }
    }

}

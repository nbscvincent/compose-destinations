package com.escanillajd.composedestination.screens

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBarDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.escanillajd.composedestination.screens.destinations.FirstScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import java.util.Date


@SuppressLint("SuspiciousIndentation")
@Destination
@Composable
fun SecondScreen(
    navigator: DestinationsNavigator
) {

    val format = SimpleDateFormat("MMMM dd,yyyy HH:mm:ss")
    val date: String?
    date = format.format(Date())


    Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .background(androidx.compose.ui.graphics.Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = date,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = androidx.compose.ui.graphics.Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 25.dp),
            )


            Spacer(modifier = Modifier.height(50.dp))
            Button(
                onClick = {

                    navigator.navigate(FirstScreenDestination)

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 25.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF783137)
                ),
                shape = RoundedCornerShape(10.dp),
            ) {
                Text(
                    text = "Back",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = androidx.compose.ui.graphics.Color.White,
                )
            }

        }
    }



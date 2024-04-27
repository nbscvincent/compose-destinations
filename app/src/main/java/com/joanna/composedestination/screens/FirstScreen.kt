package com.escanillajd.composedestination.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
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
import com.escanillajd.composedestination.screens.destinations.SecondScreenDestination
import com.escanillajd.composedestination.screens.destinations.ThirdScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.annotation.RootNavGraph



@Destination(start = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(
    navigator: DestinationsNavigator
) {

    var textField by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 25.dp),
                value = textField,
                shape = RoundedCornerShape(10.dp),
                onValueChange = { textField = it },
                label = { Text(text = "") },
                textStyle = TextStyle(
                    color = Color.Black
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                    focusedLabelColor = Color.Black,
                ),
                trailingIcon = {
                    Icon(imageVector = Icons.Default.Info, contentDescription = "")
                },
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(25.dp))
            Button(
                onClick = {

                     navigator.navigate(SecondScreenDestination)

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
                    text = "1st Button",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White,
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Button(
                onClick = {

                    navigator.navigate(ThirdScreenDestination(textField))
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
                    text = "2nd Button",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White,
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
        }
    }

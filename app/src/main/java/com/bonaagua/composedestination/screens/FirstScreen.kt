package com.bonaagua.composedestination.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bonaagua.composedestination.data.TextFieldData
import com.bonaagua.composedestination.data.TextFieldStringHolder
import com.bonaagua.composedestination.screens.destinations.SecondScreenDestination
import com.bonaagua.composedestination.screens.destinations.ThirdScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch

@RootNavGraph(start = true)
@Destination
@Composable
fun FirstScreen(
    navigator: DestinationsNavigator
) {
    val coroutineScope = rememberCoroutineScope()

    // Retrieve the text from TextFieldStringHolder
    var text by remember {
        mutableStateOf(TextFieldData(TextFieldStringHolder.getString()?.text ?: ""))
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = text.text,
            onValueChange = {
                text = text.copy(text = it)
                TextFieldStringHolder.setString(text)
            },
            label = { Text("Enter Text") },
            modifier = Modifier
                .padding(8.dp),
            shape = (RoundedCornerShape(20.dp))
        )

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Button(
                onClick = {
                    coroutineScope.launch {
                        navigator.navigate(SecondScreenDestination())
                    }
                },
                enabled = text.text.isNotEmpty(),
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Go to Second Screen")
            }
            Button(
                onClick = {
                    coroutineScope.launch {
                        navigator.navigate(ThirdScreenDestination(text.text))
                    }
                },
                enabled = text.text.isNotEmpty(),
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Go to Third Screen")
            }
        }
    }
}
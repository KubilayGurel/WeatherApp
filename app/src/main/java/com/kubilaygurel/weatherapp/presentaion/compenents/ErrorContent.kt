package com.kubilaygurel.weatherapp.presentaion.compenents


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kubilaygurel.weatherapp.presentaion.ui.theme.CustomCardColor

@Composable
fun ErrorContent(errorMessage: String,onRetry: () -> Unit){

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Column (
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = errorMessage,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = CustomCardColor.copy(alpha = 0.5f)
                ),
                onClick = onRetry
            ) {
                Text(text = "Grant Permissions", color = Color.White)
            }
        }
    }

}
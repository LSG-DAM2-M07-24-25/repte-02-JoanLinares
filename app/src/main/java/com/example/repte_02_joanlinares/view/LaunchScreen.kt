package com.example.repte_02_joanlinares.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.repte_02_joanlinares.R
import com.example.repte_02_joanlinares.Routes

@Composable
fun LaunchScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.dragonball_daima_logo),
            contentDescription = "Dragonball Daima Logo",
            modifier = Modifier
                .size(300.dp)
                .padding(10.dp)
        )
        Button(
            onClick = { navController.navigate(Routes.Screen2.route) },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .width(200.dp)
        ) {
            Text(
                text = "Entrar",
                color = Color.Black,
                fontSize = 16.sp
            )
        }
    }
}
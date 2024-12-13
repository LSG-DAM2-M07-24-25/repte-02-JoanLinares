package com.example.repte_02_joanlinares.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.repte_02_joanlinares.viewModel.ResultatViewModel
import androidx.compose.foundation.shape.RoundedCornerShape
import com.example.repte_02_joanlinares.R

@Composable
fun ResultatScreen(navController: NavController, imageId: Int, nom: String, viewModel: ResultatViewModel = viewModel()) {
    val imageResource = viewModel.getImageResourceById(imageId)

    Column(
        modifier = Modifier
            .fillMaxWidth()
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
        Spacer(modifier = Modifier.height(16.dp))
        imageResource?.let {
            Image(
                painter = painterResource(id = it),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
        }
        Text(
            text = "$nom",
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 30.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("screen2") },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.width(200.dp)
        ) {
            Text("Ir a Screen2")
        }

    }
}
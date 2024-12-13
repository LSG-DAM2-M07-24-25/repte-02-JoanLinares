package com.example.repte_02_joanlinares.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.repte_02_joanlinares.R
import com.example.repte_02_joanlinares.model.Nom


@Composable
fun TriaNomScreen(navController: NavController, imageId: Int) {
    var nom by remember { mutableStateOf(Nom("").nom) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
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
        OutlinedTextField(
            value = nom,
            onValueChange = { nom = it },
            label = { Text("Escriu el teu nom") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("screen4/$imageId/$nom") }) {
            Text("Mostrar")
        }
    }
}
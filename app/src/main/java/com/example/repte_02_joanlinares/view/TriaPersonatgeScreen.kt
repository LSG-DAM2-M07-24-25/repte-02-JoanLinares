package com.example.repte_02_joanlinares.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.repte_02_joanlinares.R
import com.example.repte_02_joanlinares.model.Imatge
import com.example.repte_02_joanlinares.viewModel.TriaPersonatgeViewModel

@Composable
fun TriaPersonatgeScreen(navController: NavController, viewModel: TriaPersonatgeViewModel = viewModel()) {
    val selectedImageId by viewModel.selectedImageId

    val images = listOf(
        Imatge(1, R.drawable.gomah),
        Imatge(2, R.drawable.goku),
        Imatge(3, R.drawable.vegeta),
        Imatge(4, R.drawable.piccolo),
        Imatge(5, R.drawable.supreme),
        Imatge(6, R.drawable.masked_majin)
    )

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
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            images.take(3).forEach { image ->
                ImageItem(image, selectedImageId, viewModel)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            images.drop(3).forEach { image ->
                ImageItem(image, selectedImageId, viewModel)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                selectedImageId?.let { id ->
                    navController.navigate("screen3/$id")
                }
            },
            enabled = selectedImageId != null,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .width(200.dp)
        ) {
            Text("Continuar")
        }
    }
}

@Composable
fun ImageItem(image: Imatge, selectedImageId: Int?, viewModel: TriaPersonatgeViewModel) {
    val borderModifier = if (selectedImageId == image.id) {
        Modifier.border(BorderStroke(2.dp, Color.Black),
            shape = RoundedCornerShape(4.dp))
    } else {
        Modifier
    }

    Image(
        painter = painterResource(id = image.resourceId),
        contentDescription = null,
        modifier = Modifier
            .size(100.dp)
            .then(borderModifier)
            .clickable { viewModel.selectImage(image.id) }
    )
}
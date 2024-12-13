package com.example.repte_02_joanlinares.viewModel

import androidx.lifecycle.ViewModel
import com.example.repte_02_joanlinares.R
import com.example.repte_02_joanlinares.model.Imatge

class ResultatViewModel : ViewModel() {
    private val images = listOf(
        Imatge(1, R.drawable.gomah),
        Imatge(2, R.drawable.goku),
        Imatge(3, R.drawable.vegeta),
        Imatge(4, R.drawable.piccolo),
        Imatge(5, R.drawable.supreme),
        Imatge(6, R.drawable.masked_majin)
    )

    fun getImageResourceById(id: Int): Int? {
        return images.find { it.id == id }?.resourceId
    }
}
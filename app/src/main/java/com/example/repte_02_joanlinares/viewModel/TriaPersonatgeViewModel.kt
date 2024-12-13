package com.example.repte_02_joanlinares.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TriaPersonatgeViewModel : ViewModel() {
    val selectedImageId = mutableStateOf<Int?>(null)

    fun selectImage(id: Int) {
        selectedImageId.value = id
    }
}
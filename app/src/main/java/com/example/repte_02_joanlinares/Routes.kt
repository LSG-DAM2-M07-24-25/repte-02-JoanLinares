package com.example.repte_02_joanlinares

sealed class Routes(val route: String) {
    object Screen1 : Routes("screen1")
    object Screen2 : Routes("screen2")
    object Screen3 : Routes("screen3/{imageId}") {
        fun createRoute(imageId: Int) = "screen3/$imageId"
    }
    object Screen4 : Routes("screen4/{imageId}/{nom}") {
        fun createRoute(imageId: Int, nom: String) = "screen4/$imageId/$nom"
    }
}

package com.example.handphone.ui.common

//untuk merepresentasikan berbagai status UI.
 // Digunakan untuk mengelola tampilan antarmuka pengguna secara dinamis.
 // Status yang mungkin adalah Loading, Success dengan data, atau Error dengan pesan error.
sealed class UiState<out T: Any?> {

    // Object untuk merepresentasikan status loading.
    object Loading : UiState<Nothing>()

    // Data class untuk merepresentasikan status sukses dengan data.

    data class Success<out T: Any>(val data: T) : UiState<T>()

    //Data class untuk merepresentasikan status error dengan pesan error.

    data class Error(val errorMessage: String) : UiState<Nothing>()
}
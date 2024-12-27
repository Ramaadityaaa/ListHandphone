package com.example.handphone.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.handphone.data.HandphoneRepository
import com.example.handphone.model.DetailHandphone
import com.example.handphone.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailHandphoneViewModel (
    private val repository: HandphoneRepository
) : ViewModel() {
    // MutableStateFlow untuk menyimpan state UI, dimulai dengan Loading
    private val _uiState: MutableStateFlow<UiState<DetailHandphone>> =
        MutableStateFlow(UiState.Loading)
    // StateFlow untuk mendapatkan state UI dari luar
    val uiState: StateFlow<UiState<DetailHandphone>>
        get() = _uiState

    // Fungsi untuk mengambil data handphone berdasarkan ID
    fun getHandphoneById(rewardId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading // Set state menjadi Loading
            _uiState.value = UiState.Success(repository.getHandphoneById(rewardId)) // Set state menjadi Success dengan data
        }
    }

    // Inti: ViewModel untuk detail handphone, mengambil data berdasarkan ID, mengelola state UI (Loading, Success) menggunakan coroutines dan StateFlow.
}
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
        private val _uiState: MutableStateFlow<UiState<DetailHandphone>> =
            MutableStateFlow(UiState.Loading)
        val uiState: StateFlow<UiState<DetailHandphone>>
        get() = _uiState

        fun getHandphoneById(rewardId: Long) {
            viewModelScope.launch {
                _uiState.value = UiState.Loading
                _uiState.value = UiState.Success(repository.getHandphoneById(rewardId))
            }
        }

}
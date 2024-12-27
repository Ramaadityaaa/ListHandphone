package com.example.handphone.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.handphone.data.HandphoneRepository
import com.example.handphone.model.DetailHandphone
import com.example.handphone.model.Handphone
import com.example.handphone.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

// ViewModel untuk mengelola data di layar home
class HomeViewModel(
    private val repository: HandphoneRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<DetailHandphone>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<DetailHandphone>>>
        get() = _uiState
    private val _groupedHandphones = MutableStateFlow<Map<Char, List<DetailHandphone>>>(emptyMap())
    // State untuk menyimpan query pencarian
    private val _query = mutableStateOf("")
    // State untuk mendapatkan query pencarian dari luar
    val query: State<String> get() = _query

    init {
        viewModelScope.launch {
            combine(repository.getAllHandphones(), _groupedHandphones) { handphones, searchResult ->
                if (_query.value.isNotBlank()) {
                    UiState.Success(searchResult.values.flatten())
                } else {
                    UiState.Success(handphones)
                }
            }.collect {
                _uiState.value = it
            }
        }
    }

    // Fungsi untuk mengambil semua data handphone
    fun getAllHandphones() {
        viewModelScope.launch {
            try {
                repository.getAllHandphones() // Mengambil data dari repository
                    .collect {
                            handphones ->
                        _uiState.value = UiState.Success(handphones) // Update state UI dengan data
                    }
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message.toString()) // Update state UI dengan error
            }
        }
    }

    // Fungsi untuk melakukan pencarian handphone
    fun search(newQuery: String) {
        _query.value = newQuery
        viewModelScope.launch {
            val searchResult = repository.searchHandphones(_query.value)
                .sortedBy { it.handphone.title }
                .groupBy { it.handphone.title[0] }

            _groupedHandphones.value = searchResult
        }
    }
}
// program viewModel di gunakan untuk mengelola data di layar home, mengambil data dari repository,
// mengelola state UI (Loading, Success, Error), melakukan pencarian, dan pengelompokan data.
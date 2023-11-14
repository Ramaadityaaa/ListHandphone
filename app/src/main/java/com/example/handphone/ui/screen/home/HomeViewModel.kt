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

class HomeViewModel(
    private val repository: HandphoneRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<DetailHandphone>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<DetailHandphone>>>
        get() = _uiState

    private val _groupedHandphones = MutableStateFlow<Map<Char, List<DetailHandphone>>>(emptyMap())
    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    init {
        // Combine the original list and the search results based on the query
        viewModelScope.launch {
            combine(repository.getAllHandphones(), _groupedHandphones) { handphones, searchResult ->
                if (_query.value.isNotBlank()) {
                    // Show search results when the query is not blank
                    UiState.Success(searchResult.values.flatten())
                } else {
                    // Show the original list when the query is blank
                    UiState.Success(handphones)
                }
            }.collect {
                _uiState.value = it
            }
        }
    }

    fun getAllHandphones() {
        viewModelScope.launch {
            try {
                repository.getAllHandphones()
                    .collect { handphones ->
                        _uiState.value = UiState.Success(handphones)
                    }
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message.toString())
            }
        }
    }

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
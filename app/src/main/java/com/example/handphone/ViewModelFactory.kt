package com.example.handphone

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.handphone.data.HandphoneRepository
import com.example.handphone.ui.screen.detail.DetailHandphoneViewModel
import com.example.handphone.ui.screen.home.HomeViewModel

// Factory untuk membuat ViewModel
class ViewModelFactory(private val repository: HandphoneRepository) :
    ViewModelProvider.NewInstanceFactory() {

    // Fungsi untuk membuat ViewModel
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        }
        else if (modelClass.isAssignableFrom(DetailHandphoneViewModel::class.java)) {
            return DetailHandphoneViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}
package com.example.handphone.di

import com.example.handphone.data.HandphoneRepository

object Injection {
    fun provideRepository(): HandphoneRepository {
        return HandphoneRepository.getInstance()
    }
}
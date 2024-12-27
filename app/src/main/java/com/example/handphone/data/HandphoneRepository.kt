package com.example.handphone.data

import androidx.compose.ui.geometry.isEmpty
import com.example.handphone.model.DetailHandphone
import com.example.handphone.model.FakeHandphoneDataSource
import com.example.handphone.model.Handphone
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

// Repository untuk data handphone.
class HandphoneRepository {

    // List untuk menyimpan detail handphone.
    private val detailHandphone = mutableListOf<DetailHandphone>()

    // Inisialisasi data dari FakeDataSource.
    init {
        if (detailHandphone.isEmpty()) {
            FakeHandphoneDataSource.dummyHandphone.forEach {
                detailHandphone.add(DetailHandphone(it, 0))
            }
        }
    }

    // Mengambil semua handphone.
    fun getAllHandphones(): Flow<List<DetailHandphone>> {
        return flowOf(detailHandphone)
    }


    fun getHandphoneById(handphoneId: Long): DetailHandphone {
        return detailHandphone.first {
            it.handphone.id == handphoneId
        }
    }


    fun searchHandphones(query: String): List<DetailHandphone> {
        return FakeHandphoneDataSource.dummyHandphone.filter {
            it.title.contains(query, ignoreCase = true)
        }.map {
            DetailHandphone(it, 0)
        }
    }


    companion object {
        @Volatile
        private var instance: HandphoneRepository? = null


        fun getInstance(): HandphoneRepository =
            instance ?: synchronized(this) {
                HandphoneRepository().apply {
                    instance = this
                }
            }
    }
}
// Inti dari program HandphoneRepository adalah menyediakan akses dan
// pengelolaan data handphone untuk aplikasi, dengan cara yang terstruktur dan terpusat.
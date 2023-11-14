package com.example.handphone.data

import com.example.handphone.model.DetailHandphone
import com.example.handphone.model.FakeHandphoneDataSource
import com.example.handphone.model.Handphone
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class HandphoneRepository {

    private val detailHandphone = mutableListOf<DetailHandphone>()

    init {
        if (detailHandphone.isEmpty()) {
            FakeHandphoneDataSource.dummyHandphone.forEach {
                detailHandphone.add(DetailHandphone(it, 0))
            }
        }
    }

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
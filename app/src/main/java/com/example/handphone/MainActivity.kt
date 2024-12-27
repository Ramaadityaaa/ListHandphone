package com.example.handphone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.handphone.ui.theme.HandphoneTheme

// Activity utama aplikasi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Mengatur konten composable
        setContent {
            // Menggunakan tema aplikasi
            HandphoneTheme {
                // Surface untuk background
                Surface(
                    modifier = Modifier.fillMaxSize(), // Mengisi seluruh layar
                    color = MaterialTheme.colorScheme.background // Menggunakan warna background dari tema
                ) {
                    // Menampilkan composable utama aplikasi
                    HandphoneApp()
                }
            }
        }
    }
}
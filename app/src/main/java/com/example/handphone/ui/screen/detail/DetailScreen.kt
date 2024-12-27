package com.example.handphone.ui.screen.detail

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.handphone.R
import com.example.handphone.ViewModelFactory
import com.example.handphone.di.Injection
import com.example.handphone.ui.common.UiState
import com.example.handphone.ui.theme.HandphoneTheme

// Composable untuk menampilkan layar detail handphone
@Composable
fun DetailScreen(
    handphoneId: Long,
    viewModel: DetailHandphoneViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository()
        )
    ),
    navigateBack: () -> Unit, // Fungsi untuk navigasi kembali
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getHandphoneById(handphoneId)
            }
            is UiState.Success -> {
                val data = uiState.data
                DetailContent(
                    data.handphone.image,
                    data.handphone.title,
                    data.handphone.price,
                    data.handphone.description,
                    onBackClick = navigateBack,
                )
            }
            is UiState.Error -> {}
        }
    }
}

// Composable untuk menampilkan konten detail handphone
@Composable
fun DetailContent(
    @DrawableRes image: Int, // Resource ID gambar handphone
    title: String, // Judul handphone
    price: String, // Harga handphone
    description: String, // Deskripsi handphone
    onBackClick: () -> Unit, // Fungsi untuk navigasi kembali
    modifier: Modifier = Modifier, // Modifier untuk mengatur tampilan
) {

    Column(modifier = modifier) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(1f)
                .padding(8.dp)
        ) {
            Box {
                Image(
                    painter = painterResource(image), // Menampilkan gambar handphone
                    contentDescription = null,
                    contentScale = ContentScale.Crop, // Mengatur skala gambar
                    modifier = modifier
                        .height(400.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
                )
                Icon(
                    imageVector = Icons.Default.ArrowBack, // Menampilkan icon back
                    contentDescription = stringResource(R.string.back), // Memberikan deskripsi untuk icon back
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable { onBackClick() }
                )
            }
            // Column untuk judul, harga, dan deskripsi
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = title, // Menampilkan judul handphone
                    textAlign = TextAlign.Center, // Mengatur alignment text
                    style = MaterialTheme.typography.headlineSmall.copy( // Mengatur style text
                        fontWeight = FontWeight.ExtraBold
                    ),
                )
                Text(
                    text = price, // Menampilkan harga handphone
                    style = MaterialTheme.typography.titleMedium.copy( // Mengatur style text
                        fontWeight = FontWeight.ExtraBold
                    ),
                    color = MaterialTheme.colorScheme.secondary // Mengatur warna text
                )
                Text(
                    text = description, // Menampilkan deskripsi handphone
                    style = MaterialTheme.typography.titleMedium.copy( // Mengatur style text
                        fontWeight = FontWeight.Normal
                    ),
                    color = MaterialTheme.colorScheme.secondary // Mengatur warna text
                )
            }
        }
    }
}

// Composable untuk menampilkan preview dari DetailContent
@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DetailContentPreview() {
    HandphoneTheme {
        DetailContent(
            R.drawable.iphone_14_purple,
            "iPhone 15 Pro Max",
            "RP. 7500",
            "Sistem kamera ganda paling canggih yang pernah ada di iPhone. Chip A15 Bionic yang secepat kilat. Lompatan besar dalam kekuatan baterai. Desain kokoh. Dan layar Super Retina XDR yang lebih cerah.\\\\n\\\\n\\n\" +\n" +
                    "                \"Isi Kotak :\\\\n\\\\n\\n\" +\n" +
                    "                \"• iPhone dengan iOS 15.\\\\n\\n\" +\n" +
                    "                \"• Kabel USB-C ke Lightning.\\\\n\\n\" +\n" +
                    "                \"• Buku Manual dan dokumentasi lain.",
            onBackClick = {},
        )
    }
}

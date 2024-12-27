package com.example.handphone.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.handphone.R
import com.example.handphone.ui.theme.HandphoneTheme

//Composable untuk menampilkan item handphone dalam bentuk card.
 // Menampilkan gambar, judul, harga, dan deskripsi handphone.

@Composable
fun HandphoneItem(
    image: Int,
    title: String,
    price: String,
    description: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(170.dp)
                .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
        )
        Text(
            text = title,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.ExtraBold
            )
        )
        Text(
            text = price,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            maxLines = 2,
            text = description,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

//Composable untuk menampilkan preview dari HandphoneItem.
@Composable
@Preview(showBackground = true)
fun RewardItemPreview() {
    HandphoneTheme {
        HandphoneItem(R.drawable.iphone_14_pro_max_deep_purple, "Jaket Hoodie Dicoding", "RP. 4.000", "Sistem kamera ganda baru merekam lebih banyak lagi hal yang Anda lihat dan sukai. Chip paling cepat yang pernah ada di ponsel pintar dan kekuatan baterai sepanjang hari memungkinkan Anda melakukan lebih banyak hal tanpa perlu sering mengisi daya.\\n\" +\n" +
                "                \"Dan kualitas video terbaik di ponsel pintar, jadi kenangan Anda terlihat lebih baik daripada sebelumnya. Layar Liquid Retina sepenuhnya 6,1 inci yang begitu penuh warna. Desain layar sepenuhnya yang begitu nyata menjadikan segalanya terlihat mengagumkan.\\n\" +\n" +
                "                \"Dengan material aluminium sekelas industri dirgantara yang kuat dan tahan lama. Membuat iPhone 11 begitu mengagumkan dikelasnya. Dengan Chip A13 Bionic yang begitu andal, semua yang Anda lakukan begitu cepat dan lancar dan juga mampu bekerja dengan cara yang paling menghemat daya, sehingga baterai lebih tahan lama.")
    }
}

// Inti dari program ini yaitu untuk menampilkan item handphone dalam bentuk card dengan gambar, judul, harga, dan deskripsi,
// menggunakan Material Design dan Compose UI.
package com.example.handphone.model

import com.example.handphone.R

//Object ini menyediakan data dummy untuk handphone.
object FakeHandphoneDataSource {

    // di bawah ini terdapat list yang berisi data dummy handphone.
     // Setiap elemen adalah objek Handphone dengan properti id, gambar, judul, harga, dan deskripsi.
    val dummyHandphone = listOf(
        Handphone(1, R.drawable.iphone_14_pro_max_deep_purple, "iPhone 14 Pro Max", "RP. 20.500.000", "Sistem kamera ganda paling canggih yang pernah ada di iPhone. Chip A15 Bionic yang secepat kilat. Lompatan besar dalam kekuatan baterai. Desain kokoh. Dan layar Super Retina XDR yang lebih cerah.\\n\\n\n" +
                "Isi Kotak :\\n\\n\n" +
                "• iPhone dengan iOS 15.\\n\n" +
                "• Kabel USB-C ke Lightning.\\n\n" +
                "• Buku Manual dan dokumentasi lain."),
        Handphone(2, R.drawable.iphone_14_pro_gold, "iPhone 14 Pro", "RP. 18.500.000", "Memotret detail menakjubkan dengan kamera Utama 48 MP. Nikmati iPhone dalam cara yang sepenuhnya baru dengan layar yang Selalu Aktif dan Dynamic Island. Deteksi Tabrakan, sebuah fitur keselamatan baru, memanggil bantuan saat Anda tak bisa.\\n\\n\n" +
                "Isi Kotak :\\n\\n\n" +
                "• iPhone dengan iOS 16.\\n\n" +
                "• Kabel USB-C ke Lightning.\\n\n" +
                "• Buku Manual dan dokumentasi lain."),
        Handphone(3, R.drawable.iphone_14_purple, "iPhone 14", "RP. 14.500.000", "Dengan sistem kamera ganda paling hebat di iPhone. Ambil foto yang memukau dalam pencahayaan rendah maupun terang. Deteksi Tabrakan,1 sebuah fitur keselamatan baru, memanggil bantuan saat Anda tak bisa.\\n\\n\n" +
                "Isi Kotak :\\n\\n\n" +
                "• iPhone dengan iOS 16.\\n\n" +
                "• Kabel USB-C ke Lightning.\\n\n" +
                "• Buku Manual dan dokumentasi lain."),
        Handphone(4, R.drawable.iphone_13_mini_pink_1_3, "iPhone 13 Mini", "RP. 13.500.000", "Sistem kamera ganda paling canggih yang pernah ada di iPhone. Chip A15 Bionic yang secepat kilat. Lompatan dalam kekuatan baterai. Desain kokoh. Dan layar Super Retina XDR yang lebih cerah.\\n\\n\n" +
                "Isi Kotak :\\n\\n\n" +
                "• iPhone dengan iOS 15.\\n\n" +
                "• Kabel USB-C ke Lightning.\\n\n" +
                "• Buku Manual dan dokumentasi lain."),
        Handphone(5, R.drawable.iphone_11_red, "iPhone 11", "RP. 7.500.000", "Sistem kamera ganda baru merekam lebih banyak lagi hal yang Anda lihat dan sukai. Chip paling cepat yang pernah ada di ponsel pintar dan kekuatan baterai sepanjang hari memungkinkan Anda melakukan lebih banyak hal tanpa perlu sering mengisi daya.\n" +
                "Dan kualitas video terbaik di ponsel pintar, jadi kenangan Anda terlihat lebih baik daripada sebelumnya. Layar Liquid Retina sepenuhnya 6,1 inci yang begitu penuh warna. Desain layar sepenuhnya yang begitu nyata menjadikan segalanya terlihat mengagumkan.\n" +
                "Dengan material aluminium sekelas industri dirgantara yang kuat dan tahan lama. Membuat iPhone 11 begitu mengagumkan dikelasnya. Dengan Chip A13 Bionic yang begitu andal, semua yang Anda lakukan begitu cepat dan lancar dan juga mampu bekerja dengan cara yang paling menghemat daya, sehingga baterai lebih tahan lama."),
        Handphone(6, R.drawable.iphone_se_3_midnight, "iPhone SE 3rd Gen", "RP. 10.800.000", "Sistem kamera ganda baru merekam lebih banyak lagi hal yang Anda lihat dan sukai. Chip paling cepat yang pernah ada di ponsel pintar dan kekuatan baterai sepanjang hari memungkinkan Anda melakukan lebih banyak hal tanpa perlu sering mengisi daya.\n" +
                "Dan kualitas video terbaik di ponsel pintar, jadi kenangan Anda terlihat lebih baik daripada sebelumnya. Layar Liquid Retina sepenuhnya 6,1 inci yang begitu penuh warna. Desain layar sepenuhnya yang begitu nyata menjadikan segalanya terlihat mengagumkan.\n" +
                "Dengan material aluminium sekelas industri dirgantara yang kuat dan tahan lama. Membuat iPhone 11 begitu mengagumkan dikelasnya. Dengan Chip A13 Bionic yang begitu andal, semua yang Anda lakukan begitu cepat dan lancar dan juga mampu bekerja dengan cara yang paling menghemat daya, sehingga baterai lebih tahan lama."),
    )
}
// inti dari program ini yaitu di gunakan untuk  menyediakan data dummy untuk deskripsi handphone pada aplikasi.
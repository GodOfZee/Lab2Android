package com.example.lab2android

data class Artwork(
    val titleRes: Int,
    val descRes: Int,
    val authorRes: Int,
    val imageRes: Int
)

val artworksList = listOf(
    Artwork(
        titleRes = R.string.title_image1,
        descRes = R.string.description_image1,
        authorRes = R.string.author_image1,
        imageRes = R.drawable.image1
    ),
    Artwork(
        titleRes = R.string.title_image2,
        descRes = R.string.description_image2,
        authorRes = R.string.author_image2,
        imageRes = R.drawable.image2
    ),
    Artwork(
        titleRes = R.string.title_image3,
        descRes = R.string.description_image3,
        authorRes = R.string.author_image3,
        imageRes = R.drawable.image3
    ),
    Artwork(
        titleRes = R.string.title_image4,
        descRes = R.string.description_image4,
        authorRes = R.string.author_image4,
        imageRes = R.drawable.image4
    )
)
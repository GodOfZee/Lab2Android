package com.example.lab2android

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource

@Composable
fun ArtworkImage(
    artwork: Artwork,
) {
    Card() {
        Box(Modifier.background(color = Color.DarkGray)) {
            Image(
                bitmap = ImageBitmap.imageResource(artwork.imageRes),
                contentDescription = stringResource(artwork.descRes),
                modifier = Modifier.padding(dimensionResource(R.dimen.padding))
            )
        }
    }
}
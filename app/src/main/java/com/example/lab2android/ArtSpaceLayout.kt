package com.example.lab2android

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.lab2android.ui.theme.Lab2AndroidTheme

@Composable
fun ArtSpaceLayout() {
    var currentIndex: Int by rememberSaveable{ mutableIntStateOf(0) }

    val context = LocalContext.current
    val isLandscape = context.resources.configuration.orientation == ORIENTATION_LANDSCAPE

    val isPreviousEnabled = currentIndex > 0
    val isNextEnabled = currentIndex < artworksList.lastIndex
    val artwork = artworksList[currentIndex]

    val onPreviousClick = {
        if (isPreviousEnabled) {
            currentIndex--
        }
    }

    val onNextClick = {
        if (isNextEnabled) {
            currentIndex++
        }
    }

    if(isLandscape)
        LandscapeLayout(
            artwork,
            isPreviousEnabled,
            isNextEnabled,
            onPreviousClick,
            onNextClick
        )
    else
        PortraitLayout(
            artwork,
            isPreviousEnabled,
            isNextEnabled,
            onPreviousClick,
            onNextClick
        )
}

@Composable
fun PortraitLayout(
    artwork: Artwork,
    isPreviousEnabled: Boolean,
    isNextEnabled: Boolean,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding))
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween) {
        ArtworkImage(artwork)
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(artwork.descRes),
                fontSize = dimensionResource(R.dimen.font_size_large).value.sp)
            Text(
                text = stringResource(artwork.authorRes),
                fontSize = dimensionResource(R.dimen.font_size_medium).value.sp)
        }

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavButton(
                stringResource(R.string.button_text_previous),
                isPreviousEnabled,
                onPreviousClick,
                stringResource(R.string.button_description_previous)
            )
            NavButton(
                stringResource(R.string.button_text_next),
                isNextEnabled,
                onNextClick,
                stringResource(R.string.button_description_next)
            )
        }
    }
}

@Composable
fun LandscapeLayout(
    artwork: Artwork,
    isPreviousEnabled: Boolean,
    isNextEnabled: Boolean,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit
) {
    Row(modifier = Modifier
        .padding(dimensionResource(R.dimen.padding))
        .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ArtworkImage(artwork)
        Column(
            Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(artwork.descRes),
                    fontSize = dimensionResource(R.dimen.font_size_large).value.sp
                )
                Text(
                    text = stringResource(artwork.authorRes),
                    fontSize = dimensionResource(R.dimen.font_size_medium).value.sp
                )
            }
            Spacer(Modifier.size(dimensionResource(R.dimen.size_spacer)))
            Row {
                NavButton(
                    stringResource(R.string.button_text_previous),
                    isPreviousEnabled,
                    onPreviousClick,
                    stringResource(R.string.button_description_previous)
                )
                NavButton(
                    stringResource(R.string.button_text_next),
                    isNextEnabled,
                    onNextClick,
                    stringResource(R.string.button_description_next)
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Preview(showBackground = true, locale = "ru")
@Preview(showBackground = true, device = "spec:width=1280dp,height=800dp,dpi=240")
@Composable
fun ArtSpacePreview() {
    Lab2AndroidTheme {
        ArtSpaceLayout()
    }
}
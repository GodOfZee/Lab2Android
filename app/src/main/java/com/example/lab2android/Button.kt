package com.example.lab2android

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics

@Composable
fun NavButton(
    text: String,
    enabled: Boolean,
    onClick: () -> Unit,
    contentDescription: String,
) {
    Button(
        modifier = Modifier
            .size(
                width = dimensionResource(R.dimen.size_button_width),
                height = dimensionResource(R.dimen.size_button_height)
            )
            .semantics{this.contentDescription = contentDescription},
        onClick = onClick,
        enabled = enabled
    ) {
        Text(text = text)
    }
}
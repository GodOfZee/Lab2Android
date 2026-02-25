package com.example.lab2android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.lab2android.ui.theme.Lab2AndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab2AndroidTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}
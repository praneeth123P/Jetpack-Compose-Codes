package com.example.logincomposeform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.semantics.SemanticsProperties.Shape
import androidx.compose.ui.unit.dp
import com.example.logincomposeform.ui.theme.LoginComposeFormTheme

class ImageScreen:ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            LoginComposeFormTheme {
                Surface (
                    color = MaterialTheme.colorScheme.background,
                )
                {
                    ImageView()
                }
            }
        }
    }
}

// one line
@Composable
fun ImageView()
{

}
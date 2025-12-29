package com.example.logincomposeform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
   Column(
       modifier = Modifier.padding(80.dp),
       horizontalAlignment = Alignment.CenterHorizontally,
       verticalArrangement =  Arrangement.Center,
   )
   {
       Text(
           text = " Android Developer image",
           color = Color.Cyan,
       )
   }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    )
    {
        val painter = painterResource(R.drawable.ic_launcher_background)

        Image(
            painter = painter,
            contentDescription = "This is Android Development",
            modifier = Modifier.fillMaxSize(),
            alignment = Alignment.Center,
            contentScale = ContentScale.Fit,
            alpha = Float.MAX_VALUE,
            colorFilter = ColorFilter.tint(color = Color.Transparent)
        )
        Text(
            text ="This is Android Development it is for android development",
        )
    }

}
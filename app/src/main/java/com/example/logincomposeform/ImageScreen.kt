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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.logincomposeform.ui.theme.LoginComposeFormTheme

class ImageScreen:ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            LoginComposeFormTheme {
                Surface (
                    color = Color.Cyan
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
           color = Color.Magenta,
           fontSize = 15.sp
       )
   }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    )
    {
        val painter = painterResource(R.drawable.andriod)

       Image(
           painter = painter,
           contentDescription = "This is image",
           modifier =Modifier.padding(20.dp),
           colorFilter = ColorFilter.tint(color = Color.Yellow, blendMode = BlendMode.Multiply)
       )
        Text(
            text = "This is Android Developer Image and  here doing mobile appliactions and using kotlin and java but kotlin is best to improvement app performance ",
            textAlign = TextAlign.Center,
            color = Color.DarkGray,
            fontFamily = FontFamily.SansSerif,
        )
    }

}
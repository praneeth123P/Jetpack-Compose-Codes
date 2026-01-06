package com.example.logincomposeform

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun Constraint(onConstarint: ()-> Unit)
{
    val context = LocalContext.current
     ConstraintLayout (
         modifier = Modifier.fillMaxSize()
     )
     {
         val (image,text) = createRefs()
         Image(
            painter = painterResource(R.drawable.andriod),
             contentDescription = "android",
             modifier = Modifier.padding(60.dp)
                 .constrainAs(image)
                 {
                     top.linkTo(parent.top)
                     start.linkTo(parent.start)
                     end.linkTo(parent.end)
                     bottom.linkTo(parent.bottom)
                 }
         )
         Text(
             text = "ANDROID",
             color = Color.Cyan,
             modifier = Modifier.padding(60.dp)
                 .constrainAs(text)
                 {
                     top.linkTo(parent.top)
                     start.linkTo(parent.start)
                     end.linkTo(parent.end)
                     bottom.linkTo(parent.bottom)
                 }
         )
     }
    Button(onClick = onConstarint)
    {
        Toast.makeText(context,"Next Page",Toast.LENGTH_LONG).show()
    }
}
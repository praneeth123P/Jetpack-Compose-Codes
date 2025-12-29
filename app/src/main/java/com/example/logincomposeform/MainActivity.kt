package com.example.logincomposeform

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Icon
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fitOutside
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.logincomposeform.ui.theme.LoginComposeFormTheme
import com.example.logincomposeform.ui.theme.PurpleGrey40

/*class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginComposeFormTheme(dynamicColor = false, darkTheme = false)
            {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                      DisplayIcon()
                }
            }
        }
    }
}


@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun DisplayIcon() {
    val checkedState = remember { mutableStateOf(false) }

    Column(
        Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = if (checkedState.value) "Like" else "Dislike",

            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        // create a toggle button with a custom icon
        IconToggleButton(
            // set default check state
            checked = checkedState.value,
            // set on check change
            onCheckedChange = {
                checkedState.value = !checkedState.value
            },
            modifier = Modifier.padding(20.dp)
        ) {
            // initialize transition
            val transition = updateTransition(checkedState.value)

            // set color of icon
            val tint by transition.animateColor(label = "iconColor") { isChecked ->
                if (isChecked) Color.Red else Color.Black
            }

            // define transition
            val size by transition.animateDp(
                transitionSpec = {
                    // on below line we are specifying transition
                    if (false isTransitioningTo true) {
                        // on below line we are specifying key frames
                        keyframes {
                            // on below line we are specifying animation duration
                            durationMillis = 250
                            // on below line we are specifying animations.
                            30.dp at 0 using LinearOutSlowInEasing // for 0-15 ms
                            35.dp at 15 using FastOutLinearInEasing // for 15-75 ms
                            40.dp at 75 // ms
                            35.dp at 150 // ms
                        }
                    } else {
                        spring(stiffness = Spring.StiffnessVeryLow)
                    }
                },
                label = "Size"
            ) { 30.dp }

            // create icon for toggle button.
            Icon(
                imageVector = if (checkedState.value) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                contentDescription = "Icon",
                tint = tint,
                modifier = Modifier.size(size)
            )
        }
    }
}*/














//this is function TextForm code that means down code
                /*LoginComposeFormTheme {
                Surface(
                    //color = MaterialTheme.colorScheme.background
                )
                {
//                    TextForm()
//                    Text2()
                }
            }
        }
    }
}*/


//these codes are practising
                /*@Preview
@Composable
fun TextForm() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    )
    {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
//                .clickable {
//                    Toast.makeText(context,"Hi",Toast.LENGTH_LONG).show()
//                },
            text = "Welcome to Jetapack Compose",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.SansSerif,
            letterSpacing = 1.5.sp,
            textDecoration = TextDecoration.Underline,
            lineHeight = 24.sp,
            // Used to handle overflowed text (Ellipsis).
            overflow = TextOverflow.Ellipsis,

            // Whether the text should wrap if it exceeds the width of its container (true).
            softWrap = true,

            // The maximum number of lines for the text (2).
            maxLines = 2,

            // The minimum number of lines for the text (1).
            minLines = 1,
            onTextLayout = { textLayoutResult: TextLayoutResult ->
                // Example usage of onTextLayout callback
                val lineCount = textLayoutResult.lineCount
                println("Line Count: $lineCount")
            },
            // below line is used to add
            // style to our text view.
            style = TextStyle(

                // background is use to specify background
                // color to our text view.
                background = Color.Green,

                // shadow to make our
                // text view elevated.
                shadow = Shadow(color = Color.Gray, blurRadius = 40f),
            )
        )
    }
}


@Composable
fun Text2 ()
{
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        {
            Text(
                modifier = Modifier.fillMaxWidth()
                    .padding(50.dp),
                text = "Hello World",
                color = Color.Gray,
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
            )
        }
    )
}*/



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginComposeFormTheme {
               // MyContent()
                Alertdialog()
            }
        }
    }
}


/*@Composable
fun MyContent() {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        {
            Text(
                modifier = Modifier.fillMaxHeight()
                    .padding(130.dp),
                text = "About Me",
                color = Color.Blue,
                textAlign = TextAlign.Center,
            )
        }
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        Button(
            onClick = {
                Toast.makeText(context, "Button Clicked", Toast.LENGTH_LONG).show()
            }
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            )
            {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                )
                {
                    Text(text = " Praneeth", color = Color.Blue)
                    Text(text = "CSE", color = Color.Blue)
                    Text(text ="Android Developer",color =Color.Blue)
                }
            }
        }
    }
}*/















      








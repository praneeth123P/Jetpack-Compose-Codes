package com.example.logincomposeform

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.example.logincomposeform.ui.theme.LoginComposeFormTheme

class AlertDialogScreen: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginComposeFormTheme(darkTheme = false, dynamicColor = false)
            {
                Surface {
                    //Alertdialog()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Alertdialog() {
   var showDialog by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier.fillMaxWidth().padding(100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Alert Dialog",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Cyan
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Button(onClick = { showDialog = true }) {
                Text("Show Button")
            }
           if(showDialog)
           {
               AlertDialog(
                   onDismissRequest = {showDialog = false},
                   confirmButton = {
                       Button(onClick = {showDialog = false})
                       {
                           Text("Confirm")
                       }
                   },
                  dismissButton = {
                      TextButton(onClick ={showDialog = false}) {
                          Text("Dismiss")
                      }
                  },
                   icon =
                   {
                       Icon(imageVector = Icons.Default.Warning, contentDescription = "Warning")
                   },
                   text = {
                       Text(text = "This is the content of the alert dialog.", color = Color.DarkGray)
                   },
                   // set padding for contents inside the box
                   modifier = Modifier.padding(16.dp),
                   // define box shape
                   shape = RoundedCornerShape(16.dp),
                   // set box background color
                   containerColor = Color.White,
                   // set icon color
                   iconContentColor = Color.Red,
                   // set title text color
                   titleContentColor = Color.Black,
                   // set text color
                   textContentColor = Color.DarkGray,
                   // set elevation
                   tonalElevation = 8.dp,
                   // set properties
                   properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = false)
               )
           }
        }
    }







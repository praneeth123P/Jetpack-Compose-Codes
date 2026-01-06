package com.example.logincomposeform

import android.graphics.drawable.Icon
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
/*fun ScaffoldScren()
{
    val context = LocalContext.current
   Scaffold(
       topBar = {
           TopAppBar(
               title = { Text("Top Bar") },
               colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primaryContainer)
           )
       },
       floatingActionButton = {
           FloatingActionButton(
               containerColor = Color.Gray,
               onClick =
               {
                   Toast.makeText(context, "Button Clicked", Toast.LENGTH_LONG).show()
               }
           )
           {
               Icon(Icons.Filled.Add, contentDescription = "ADD")
           },
           content = { paddingValues ->
               Box(
                   modifier = Modifier
                       .padding(paddingValues)
                       .fillMaxSize()
               ) {
                   Text("Content", modifier = Modifier.align(Alignment.Center))
               }
           },

           // bottom app bar
           bottomBar = @androidx.compose.runtime.Composable {
               BottomAppBar {
                   Text(
                       text = "Bottom Bar",
                       modifier = Modifier.fillMaxWidth(),
                       textAlign = TextAlign.Center
                   )
               }
           }
           )

}*/





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldScreen() {
    val context = LocalContext.current
    Scaffold(
        // top app bar
        topBar = {
            TopAppBar(
                title = { Text("Top Bar") },
                colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.secondary)
            )
        },

        // floating button
        floatingActionButton = {
            FloatingActionButton(
                containerColor = MaterialTheme.colorScheme.primary,
                onClick = {
                    Toast.makeText(context, "Button clicked", Toast.LENGTH_SHORT).show()
                }
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        },

        // main surface
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                Text("Content", modifier = Modifier.align(Alignment.Center))
            }
        },

        // bottom app bar
        bottomBar = {
            BottomAppBar {
                Text(
                    text = "Bottom Bar",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    )
}
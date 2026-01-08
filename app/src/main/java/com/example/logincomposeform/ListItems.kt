package com.example.logincomposeform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.logincomposeform.ui.theme.LoginComposeFormTheme

class ListView : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginComposeFormTheme(dynamicColor = false, darkTheme = false)
            {
                List()
            }
        }
    }
}

@Composable
fun List()
{
    val list = listOf("Android Development","C","C++","JAVA","PYTHON")
    Column (
        modifier = Modifier.padding(20.dp),
        //horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Text(
            text = "ListItems Of Languages",
            color = Color.Cyan
        )
    }
    LazyColumn {
        items(list) {languages ->
              Text(languages,modifier = Modifier.padding(50.dp))
            HorizontalDivider()
        }
    }
}
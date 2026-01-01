package com.example.logincomposeform

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@SuppressLint("InvalidColorHexValue")
@Composable
fun HomeScreen()
{
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Icon(
            imageVector = Icons.Filled.Home,
            contentDescription = "home",
            tint = Color(0X8391314442)
        )
        Text(text = "Home",color = Color.Black)
    }
}

@SuppressLint("InvalidColorHexValue")
@Composable
fun SearchScreen()
{
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "search",
                tint = Color(0X8391314442)
            )
            Text(text = "Search",color = Color.Black)
        }
    }

@SuppressLint("InvalidColorHexValue")
@Composable
fun AccountBox()
{
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Icon(
            imageVector = Icons.Filled.AccountBox,
            contentDescription = "account",
            tint = Color(0X8391314442)
        )
        Text(text = "Account",color = Color.Black)
    }
}
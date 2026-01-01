package com.example.logincomposeform.data.network

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import com.example.logincomposeform.data.model.BottomClass

object ConstantClasses
{
    val BottomClass = listOf(
        BottomClass(
            label = " Home",
            icon = Icons.Filled.Home,
            route = "home"
        ),
        BottomClass(
            label = "Search",
            icon = Icons.Filled.Search,
            route = "search"
        ),
        BottomClass(
            label = "Profile",
            icon = Icons.Filled.AccountBox,
            route = "account"
        )
    )
}
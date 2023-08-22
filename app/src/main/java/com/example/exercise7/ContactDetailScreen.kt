package com.example.exercise7

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ContactDetailScreen(
    name: String,
    number: String
) {
    Text(text = "ContactDetailScreen \n $name \n $number")
}
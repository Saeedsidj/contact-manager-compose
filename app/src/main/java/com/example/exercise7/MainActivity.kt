package com.example.exercise7

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exercise7.ui.theme.Exercise7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Exercise7Theme {
                ContactListScreen(contacts = contactList)
            }
        }
    }
}

@Composable
fun ContactListScreen(contacts: List<Contact>) {
    LazyColumn (
        verticalArrangement =Arrangement.spacedBy(5.dp),
        contentPadding = PaddingValues(14.dp)
    ){
        itemsIndexed(contacts) { _, contact ->
            Column (
                Modifier.clickable{
                    Log.d("TAG", "ContactItem: ${contact.name}")
                }.fillMaxWidth().clip(RoundedCornerShape(12.dp)).border(3.dp,Color.Black,
                    RoundedCornerShape(12.dp)
                )
            ){
                Text(
                    text = contact.name,
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(16.dp)
                )
                Text(
                    text = contact.phoneNumber,
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                )
            }
        }
    }
}

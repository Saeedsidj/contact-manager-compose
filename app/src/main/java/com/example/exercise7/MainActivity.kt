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
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.exercise7.ui.theme.Exercise7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, "home") {
                composable("home") {
                    ContactListScreen(
                        contactList,
                        navigateToDetail = { name, number ->
                            navController.navigate("contactDetail/$name/$number")
                        }
                    )
                }
                composable(
                    "contactDetail/{name}/{number}",
                    arguments = listOf(
                        navArgument("name") {
                            type = NavType.StringType
                            nullable = true
                        },
                        navArgument("number") {
                            type = NavType.StringType
                            nullable = true
                        }
                    )
                ) { entry ->
                    val name = entry.arguments?.getString("name")!!
                    val number = entry.arguments?.getString("number")!!

                    ContactDetailScreen(name, number)
                }
            }
        }
    }

    private fun ContactListScreen(navigateToDetail: Any) {


    }
}

@Composable
fun ContactListScreen(
    contacts: List<Contact>,
    navigateToDetail: (name: String, phoneNumber: String) -> Unit
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        contentPadding = PaddingValues(14.dp)
    ) {
        itemsIndexed(contacts) { _, contact ->
            Column(
                Modifier
                    .clickable {
                        navigateToDetail(contact.name, contact.phoneNumber)
                    }
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .border(
                        3.dp, Color.Black,
                        RoundedCornerShape(12.dp)
                    )
            ) {
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


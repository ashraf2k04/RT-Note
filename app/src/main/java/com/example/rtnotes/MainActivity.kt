package com.example.rtnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rtnotes.navigation.Screens
import com.example.rtnotes.screens.HomeScreen
import com.example.rtnotes.screens.NoteDetailScreen
import com.example.rtnotes.ui.theme.RTNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RTNotesTheme {
                MainScreenWithNavigation()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenWithNavigation(){

    val item = Note(
        id = 4,
        title = "Book Recommendations",
        content = "The Lord of the Rings, Pride and Prejudice, 1984",
        timestamp = System.currentTimeMillis() - 2592000000
    )

    val items = generateSampleNotes()

    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("RT Notes") }
            )
        },
        floatingActionButton = {
            Row(
                modifier = Modifier.clip(RoundedCornerShape(20.dp)).background(color = MaterialTheme.colorScheme.surfaceContainer).padding(16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                Text("New", fontWeight = FontWeight.Bold, fontSize = 25.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    Icons.Default.AddCircle,
                    null,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    ) {
        Box( modifier = Modifier.padding(it).fillMaxSize()){
            NavHost(navController, Screens.HomeScreen.route){
                composable(route = Screens.HomeScreen.route){
                    HomeScreen(items)
                }
                composable(route = Screens.NoteScreen.route){
                    NoteDetailScreen(
                        note = item,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RTNotesTheme {
        MainScreenWithNavigation()
    }
}


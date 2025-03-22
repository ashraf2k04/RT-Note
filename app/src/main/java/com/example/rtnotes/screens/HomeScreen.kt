package com.example.rtnotes.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rtnotes.Note
import com.example.rtnotes.generateSampleNotes

@Composable
fun HomeScreen(items: List<Note>) {
    Box(modifier = Modifier.fillMaxSize()){
        if(items.isEmpty()){
            Text("No notes available")
        }else{
            NoteList(items)
        }
    }
}

@Composable
fun NoteList(items: List<Note>) {
    val deviceWidth = LocalConfiguration.current.screenWidthDp
    val itemWidth = deviceWidth / 2
    LazyVerticalGrid( columns = GridCells.Adaptive(itemWidth.dp)) {
        items(items.size) { index ->
            NoteItem(items[index])
        }
    }
}

@Composable
fun NoteItem(note: Note) {
    Card(modifier = Modifier.height(250.dp).padding(2.dp)) {
        Column(
            Modifier.fillMaxSize().padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(note.title, fontSize = 25.sp, fontWeight = FontWeight.Bold, modifier = Modifier.height(75.dp).padding(top =4.dp), overflow = TextOverflow.Ellipsis, textAlign = TextAlign.Center)
            Text(note.content, fontSize = 18.sp, softWrap = true, overflow = TextOverflow.Ellipsis)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Show(){
    HomeScreen(generateSampleNotes())
}
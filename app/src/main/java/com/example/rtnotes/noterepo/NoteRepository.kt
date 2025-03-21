package com.example.rtnotes.noterepo

import com.example.rtnotes.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(note: Note)
    fun getAllNotes(): Flow<List<Note>>
}

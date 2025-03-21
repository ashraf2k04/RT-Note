package com.example.rtnotes.noterepo

import com.example.rtnotes.Note
import com.example.rtnotes.database.NoteDao
import com.example.rtnotes.database.NoteEntity
import kotlinx.coroutines.flow.Flow

import kotlinx.coroutines.flow.map

class NoteRepositoryImpl(private val noteDao: NoteDao) : NoteRepository {
    override suspend fun insertNote(note: Note) {
        noteDao.insert(note.toEntity())
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.delete(note.toEntity())
    }

    override fun getAllNotes(): Flow<List<Note>> {
        return noteDao.getAllNotes().map { entities ->
            entities.map { it.toDomain() }
        }
    }
}

fun Note.toEntity() = NoteEntity(id, title, content, timestamp)
fun NoteEntity.toDomain() = Note(id, title, content, timestamp)


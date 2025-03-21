package com.example.rtnotes.noterepo

import com.example.rtnotes.Note

class AddNoteUseCase(private val repository: NoteRepository) {
    suspend operator fun invoke(note: Note) {
        repository.insertNote(note)
    }
}

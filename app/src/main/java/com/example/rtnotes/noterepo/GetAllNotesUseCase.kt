package com.example.rtnotes.noterepo

import com.example.rtnotes.Note
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(
    private val repository: NoteRepository
) {
    operator fun invoke(): Flow<List<Note>> {
        return repository.getAllNotes()
    }
}

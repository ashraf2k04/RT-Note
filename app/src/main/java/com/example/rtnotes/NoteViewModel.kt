package com.example.rtnotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rtnotes.noterepo.AddNoteUseCase
import com.example.rtnotes.noterepo.DeleteNoteUseCase
import com.example.rtnotes.noterepo.GetAllNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    getAllNotesUseCase: GetAllNotesUseCase,
    private val addNoteUseCase: AddNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
) : ViewModel() {

    val notes: StateFlow<List<Note>> = getAllNotesUseCase().stateIn(
        viewModelScope,
        SharingStarted.Lazily,
        emptyList()
    )

    fun addNote(note: Note) {
        viewModelScope.launch {
            addNoteUseCase(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            deleteNoteUseCase(note)
        }
    }
}

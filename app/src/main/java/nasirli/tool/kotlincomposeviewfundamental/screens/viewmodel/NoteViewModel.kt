package nasirli.tool.kotlincomposeviewfundamental.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import nasirli.tool.kotlincomposeviewfundamental.screens.roomDB.Note
import kotlin.coroutines.coroutineContext

class NoteViewModel(private val repository: NoteRepository) : ViewModel() {
    fun getNotes() = repository.getAllNotes().asLiveData(viewModelScope.coroutineContext)
    fun upsertNote(note: Note) {
        viewModelScope.launch {
            repository.upsertNote(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            repository.deleteNote(note)
        }
    }
}
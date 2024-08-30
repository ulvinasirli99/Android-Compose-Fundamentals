package nasirli.tool.kotlincomposeviewfundamental.screens.viewmodel

import nasirli.tool.kotlincomposeviewfundamental.screens.roomDB.Note
import nasirli.tool.kotlincomposeviewfundamental.screens.roomDB.NoteDatabase

class NoteRepository(private val db: NoteDatabase) {

    suspend fun upsertNote(note: Note) {
        db.dao.upsertNote(note)
    }


    suspend fun deleteNote(note: Note) {
        db.dao.deleteNote(note)
    }


    fun getAllNotes() =  db.dao.getAllNotes()
}
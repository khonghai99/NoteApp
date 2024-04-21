package com.haikm.noteapp.feature.note.data

import com.haikm.noteapp.feature.note.domain.Note

interface NoteRepository {
    fun getAllNotes(): List<Note>
    fun addOrUpdateNote(note: Note)
    fun deleteNoteById(noteId: Long)
    fun getNoteById(noteId: Long?): Note?
}
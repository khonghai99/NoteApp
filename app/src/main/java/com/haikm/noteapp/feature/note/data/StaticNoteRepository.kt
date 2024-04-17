package com.haikm.noteapp.feature.note.data

import com.haikm.noteapp.feature.note.domain.Note
import com.thedeanda.lorem.LoremIpsum
import java.util.Date

class StaticNoteRepository : NoteRepository {
    private val notes = mutableListOf<Note>()

    init {
        initDataNote()
    }

    private fun initDataNote() {
        val lorem = LoremIpsum.getInstance()
        repeat(10) {
            val title = lorem.getWords(3)
            val content = lorem.getParagraphs(2, 4)
            notes.add(Note(it, title, content, Date(), Date()))
        }
    }

    override fun addOrUpdateNote(note: Note) {
        val existingNote = notes.find { it.id == note.id }
        if (existingNote != null) {
            val index = notes.indexOf(existingNote)
            notes[index] = note.copy(updatedAt = Date())
        } else {
            val newNote = note.copy(
                createdAt = Date(),
                updatedAt = Date()
            )
            notes.add(newNote)
        }
    }

    override fun getAllNotes(): List<Note> {
        return notes.toList()
    }

    override fun deleteNoteById(noteId: Int) {
        val note = notes.find { it.id == noteId }
        note?.let {
            notes.remove(it)
        }
    }

    override fun getNoteById(noteId: Int?): Note? {
        noteId?: return null
        return notes.find { it.id == noteId }
    }
}
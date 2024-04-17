package com.haikm.noteapp.feature.note.domain

import java.util.Date

data class Note(
    val id: Int,
    val title: String,
    val content: String,
    val createdAt: Date,
    val updatedAt: Date,
)
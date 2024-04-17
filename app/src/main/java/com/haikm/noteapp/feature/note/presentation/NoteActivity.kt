package com.haikm.noteapp.feature.note.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.haikm.noteapp.R
import com.haikm.noteapp.databinding.ActivityNoteBinding

class NoteActivity : AppCompatActivity() {
    private val binding by lazy { ActivityNoteBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportFragmentManager.commit {
            replace<NoteListFragment>(R.id.fragmentContainer, tag = "NoteListFragment")
        }
    }
}
package com.haikm.noteapp.feature.note.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.haikm.noteapp.databinding.FragmentAddNoteBinding
import com.haikm.noteapp.feature.note.data.StaticNoteRepository
import com.haikm.noteapp.feature.note.domain.Note
import java.util.Date

class NoteAddFragment : Fragment() {
    private var _binding: FragmentAddNoteBinding? = null
    private val titleText by lazy {
        binding.edtTitle.text
    }
    private val contentText by lazy {
        binding.edtContent.text
    }
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            ivBack.setOnClickListener {
                parentFragmentManager.popBackStack()
            }
            fabSave.setOnClickListener {
                if (titleText.toString().trim().isEmpty() || contentText.toString().trim().isEmpty()) {
                    Toast.makeText(
                        requireContext(),
                        "Content or title should not empty",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }
                StaticNoteRepository.addOrUpdateNote(
                    Note(
                        System.currentTimeMillis(),
                        title = titleText.toString(),
                        content = contentText.toString(),
                        createdAt = Date(),
                        updatedAt = Date(),
                    )
                )
                parentFragmentManager.popBackStack()
            }
        }
    }
}
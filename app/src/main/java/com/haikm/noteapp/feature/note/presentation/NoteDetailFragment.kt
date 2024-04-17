package com.haikm.noteapp.feature.note.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.haikm.noteapp.databinding.FragmentNoteDetailBinding
import com.haikm.noteapp.feature.note.data.StaticNoteRepository
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class NoteDetailFragment : Fragment() {
    companion object {
        const val ARG_ID = "ARG_ID"
    }

    private var _binding: FragmentNoteDetailBinding? = null
    private val binding get() = _binding!!
    private val note by lazy { repository.getNoteById(arguments?.getInt(ARG_ID)) }
    private val noteId by lazy { arguments?.getInt(ARG_ID) }
    private val repository by lazy { StaticNoteRepository() }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initListener()
    }

    private fun initView() {
        with(binding) {
            tvTitleNote.text = note?.title ?: ""
            tvContentNote.text = note?.content ?: ""
            tvDateCreate.text = formatDate(note?.createdAt)
        }
    }

    private fun formatDate(date: Date?): String {
        date ?: return ""
        val sdf = SimpleDateFormat("d MMMM yyyy, hh:mm a", Locale.getDefault())
        return sdf.format(date)
    }

    private fun initListener() {
        with(binding) {
            ivBack.setOnClickListener {
                parentFragmentManager.popBackStack()
            }
            ivDelete.setOnClickListener {
                noteId?.let { id -> repository.deleteNoteById(id) }
            }
            ivShare.setOnClickListener {
                Toast.makeText(requireContext(), "Click Share", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
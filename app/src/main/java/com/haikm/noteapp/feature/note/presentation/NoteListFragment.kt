package com.haikm.noteapp.feature.note.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.haikm.noteapp.R
import com.haikm.noteapp.databinding.FragmentNoteListBinding
import com.haikm.noteapp.feature.note.data.NoteRepository
import com.haikm.noteapp.feature.note.data.StaticNoteRepository

class NoteListFragment : Fragment() {
    private var _binding: FragmentNoteListBinding? = null
    private val binding get() = _binding!!
    private val noteAdapter by lazy { NoteAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteListBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        initAdapter()
    }

    private fun initListener() {
        with(binding) {
            fabNewNote.setOnClickListener {
                navigateToAddNew()
            }
            ivIdea.setOnClickListener {
                Toast.makeText(requireContext(), "Click idea", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun navigateToDetail(id: Long) {
        parentFragmentManager.commit {
            replace<NoteDetailFragment>(
                R.id.fragmentContainer, tag = "NoteDetailFragment",
                bundleOf(
                    NoteDetailFragment.ARG_ID to id
                )
            )
            setReorderingAllowed(true)
            addToBackStack("NoteDetailFragment")
        }
    }

    private fun navigateToAddNew() {
        parentFragmentManager.commit {
            replace<NoteAddFragment>(R.id.fragmentContainer, tag = "NoteAddFragment")
            setReorderingAllowed(true)
            addToBackStack("NoteAddFragment")
        }
    }

    private fun initAdapter() {
        noteAdapter.apply {
            setOnItemClick {
                navigateToDetail(it)
            }
            submitList(StaticNoteRepository.getAllNotes())
        }
        binding.rvListNote.adapter = noteAdapter
    }
}
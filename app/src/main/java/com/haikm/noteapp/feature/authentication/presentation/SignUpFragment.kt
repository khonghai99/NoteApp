package com.haikm.noteapp.feature.authentication.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.haikm.noteapp.databinding.FragmentSignUpBinding
import com.haikm.noteapp.feature.note.presentation.NoteActivity

class SignUpFragment : Fragment() {
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            ivBack.setOnClickListener {
                parentFragmentManager.popBackStack()
            }
            tvSignIn.setOnClickListener {
                parentFragmentManager.popBackStack()
            }
            tvCreateAccount.setOnClickListener {
                navigateToNoteList()
            }
        }

    }

    private fun navigateToNoteList() {
        context?.startActivity(Intent(requireContext(), NoteActivity::class.java))
        activity?.finish()
    }
}
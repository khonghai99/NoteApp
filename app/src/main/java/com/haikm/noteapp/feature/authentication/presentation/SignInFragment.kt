package com.haikm.noteapp.feature.authentication.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.haikm.noteapp.R
import com.haikm.noteapp.databinding.FragmentSignInBinding
import com.haikm.noteapp.feature.note.presentation.NoteActivity

class SignInFragment : Fragment() {
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvLogin.setOnClickListener {
            navigateToNoteList()
        }
        binding.tvSignUp.setOnClickListener {
            navigateToSignUp()
        }
    }

    private fun navigateToNoteList() {
        context?.startActivity(Intent(requireContext(), NoteActivity::class.java))
        activity?.finish()
    }

    private fun navigateToSignUp() {
        parentFragmentManager.commit {
            replace<SignUpFragment>(R.id.fragmentContainer, tag = "SignUpFragment")
            setReorderingAllowed(true)
            addToBackStack("SignUpFragment")
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}


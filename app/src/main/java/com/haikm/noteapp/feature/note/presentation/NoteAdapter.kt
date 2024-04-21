package com.haikm.noteapp.feature.note.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.haikm.noteapp.databinding.LayoutItemNoteBinding
import com.haikm.noteapp.feature.note.domain.Note

class NoteAdapter : ListAdapter<Note, NoteAdapter.NoteViewHolder>(DiffNote()) {
    class DiffNote : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }

    private var onItemClick: (id: Long) -> Unit = { /* no-op */ }
    fun setOnItemClick(onClick: (id: Long) -> Unit) = apply { this.onItemClick = onClick }

    inner class NoteViewHolder(private val binding: LayoutItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Note) {
            with(binding) {
                tvTitleNote.text = item.title
                tvContentNote.text = item.content
                itemView.setOnClickListener {
                    onItemClick(item.id)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutItemNoteBinding.inflate(
            inflater,
            parent,
            false
        )
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
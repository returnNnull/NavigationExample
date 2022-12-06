package com.bam.navigationexample.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bam.navigationexample.R
import com.bam.navigationexample.databinding.NoteListItemBinding
import com.bam.navigationexample.model.Note

class NoteListAdapter : RecyclerView.Adapter<NoteListAdapter.ViewHolder>() {

    var items: List<Note> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private var itemClick: (Note) -> Unit = {}
    fun itemClick(listener: (Note) -> Unit) {
        itemClick = listener
    }

    private var deleteClick: (Note) -> Unit = {}
    fun deleteClick(listener: (Note) -> Unit) {
        deleteClick = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.note = items[position]
        holder.itemView.setOnClickListener {
            itemClick(items[position])
        }

        holder.binding.deleteBtn.setOnClickListener {
            deleteClick(items[position])
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, items.size)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = NoteListItemBinding.bind(view)

    }
}
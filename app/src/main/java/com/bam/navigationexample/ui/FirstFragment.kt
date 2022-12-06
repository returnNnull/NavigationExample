package com.bam.navigationexample.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.bam.navigationexample.adapters.NoteListAdapter
import com.bam.navigationexample.model.NoteRepository
import com.bam.navigationexample.R
import com.bam.navigationexample.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = NoteListAdapter()
        adapter.items = NoteRepository.getAll()

        adapter.itemClick {
            val id = it.id
            val args = Bundle()
            args.putInt("NOTE_ID", id)
            Navigation.findNavController(binding.root).navigate(R.id.action_firstFragment_to_secondFragment, args)
        }

        adapter.deleteClick {
            NoteRepository.delete(it)
        }

        binding.recyclerView.adapter = adapter

        binding.addNoteBtn.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_firstFragment_to_secondFragment)
        }


    }

}
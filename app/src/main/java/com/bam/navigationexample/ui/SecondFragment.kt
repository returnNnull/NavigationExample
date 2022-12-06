package com.bam.navigationexample.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.bam.navigationexample.model.Note
import com.bam.navigationexample.model.NoteRepository
import com.bam.navigationexample.R
import com.bam.navigationexample.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    lateinit var binding: FragmentSecondBinding
    private var selectNoteId: Int = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        selectNoteId = requireArguments().getInt("NOTE_ID")
        binding = FragmentSecondBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (selectNoteId != -1){
            val note = NoteRepository.getById(selectNoteId)
            binding.note = note
        }

        binding.saveBtn.setOnClickListener {
            val title = binding.editTextNoteTitle.text.toString()
            val body = binding.editTextNoteBody.text.toString()
            val note = Note(title = title, body = body)
            if (selectNoteId != -1){
                note.id = selectNoteId
                NoteRepository.update(note)
            }
            else {
                NoteRepository.add(note)
            }

            Navigation.findNavController(binding.root).navigate(R.id.action_secondFragment_to_firstFragment)
        }

    }

}
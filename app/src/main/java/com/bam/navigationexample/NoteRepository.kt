package com.bam.navigationexample

class NoteRepository {


    companion object {
        private val list = mutableListOf<Note>()
        private var idCount = 0
        fun getAll()  = list
        fun add(note: Note) {
            note.id = idCount
            idCount++
            list.add(note)
        }
    }


}
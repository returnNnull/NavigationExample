package com.bam.navigationexample.model

class NoteRepository {


    companion object {
        private val list = mutableListOf<Note>()

        init {
            for (i in 0..100){
                val note = Note(i, "title$i", "body$i")
                list.add(note)
            }
        }
        private var idCount = 101
        fun getAll()  = list
        fun add(note: Note) {
            note.id = idCount
            idCount++

            if (note.title == ""){
                note.title = "Пустой заголовок"
            }
            list.add(note)
        }

        fun update(note: Note){
            val oldNote = list.find { it.id == note.id }
            if (oldNote != null){
                val index = list.indexOf(oldNote)
                list[index] = note
            }
        }

        fun getById(id: Int) = list.find { it.id == id}


        fun delete(note: Note) = list.remove(note)
    }


}
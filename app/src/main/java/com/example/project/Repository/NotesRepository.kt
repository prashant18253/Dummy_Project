package com.example.project.Repository

import androidx.lifecycle.LiveData
import com.example.project.Model.Models
import com.example.project.db.NotesDAO

class NotesRepository(private val notesDAO: NotesDAO) {
    fun getNotes() : LiveData<List<Models.Note>>{
        return notesDAO.getNotes()
    }

    suspend fun updateNote(note: Models.Note){
        notesDAO.updateNote(note)
    }

    suspend fun addNote(note: Models.Note){
        notesDAO.addNote(note)
    }

    suspend fun deleteNote(note: Models.Note){
        notesDAO.deleteNote(note)
    }

}

//class NotesRepository(private val notesDAO: NotesDAO) {
//    fun getNotes() : LiveData<List<Notes>>{
//        return notesDAO.getNotes()
//    }
//
//    suspend fun updateNote(note: Notes){
//        notesDAO.updateNote(note)
//    }
//
//    suspend fun addNote(note: Notes){
//        notesDAO.addNote(note)
//    }
//
//    suspend fun deleteNote(note: Notes){
//        notesDAO.deleteNote(note)
//    }
//
//}
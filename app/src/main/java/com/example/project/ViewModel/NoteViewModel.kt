package com.example.project.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project.Model.Models
import com.example.project.Repository.NotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(private val noteRepo : NotesRepository): ViewModel() {

    fun getNotes() : LiveData<List<Models.Note>>{
        return noteRepo.getNotes()
    }

    fun updateNote(note: Models.Note){
        viewModelScope.launch(Dispatchers.IO){
            noteRepo.updateNote(note)
        }

    }
    fun deleteNote(note: Models.Note){
        viewModelScope.launch(Dispatchers.IO){
            noteRepo.deleteNote(note)
        }
    }

    fun addNote(note: Models.Note){
        viewModelScope.launch(Dispatchers.IO){
            noteRepo.addNote(note)
        }
    }

}
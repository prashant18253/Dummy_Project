package com.example.project.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.project.Repository.NotesRepository

class NotesViewModelFactory(private val noteRepo : NotesRepository) :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteViewModel(noteRepo) as T
    }
}
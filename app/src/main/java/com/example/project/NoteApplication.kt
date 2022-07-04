package com.example.project

import android.app.Application
import com.example.project.Repository.NotesRepository
import com.example.project.db.NotesDatabase

class NoteApplication : Application() {
    lateinit var noteRepo : NotesRepository
    override fun onCreate() {
        super.onCreate()
        initlialise()
    }

    private fun initlialise() {
        val database = NotesDatabase.getDatabase(applicationContext)
        noteRepo = NotesRepository(database.notesDao())
    }
}
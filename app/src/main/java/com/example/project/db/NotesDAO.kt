package com.example.project.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.project.Model.Models

@Dao
interface NotesDAO {

    @Query("Select * from notes")
    fun getNotes(): LiveData<List<Models.Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note : Models.Note)

    @Delete
    suspend fun deleteNote(note: Models.Note)

    @Update
    suspend fun updateNote(note: Models.Note)

}
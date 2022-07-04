package com.example.project.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.project.Model.Models

@Database(entities = [Models.Note::class, Models.Date::class], version =1, exportSchema = false)
abstract class NotesDatabase : RoomDatabase(){

    abstract fun notesDao() : NotesDAO
    companion object{

        @Volatile
        private var Instance : NotesDatabase?= null

        fun getDatabase(context : Context) : NotesDatabase {
            if(Instance == null){
                Instance = Room.databaseBuilder(context, NotesDatabase::class.java, "notes_database").build()
            }
            return Instance!!
        }
    }
}
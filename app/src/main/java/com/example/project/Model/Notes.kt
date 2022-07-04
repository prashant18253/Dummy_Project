package com.example.project.Model

import androidx.room.Entity
import androidx.room.PrimaryKey


sealed class Models{

    @Entity(tableName = "notes")
    class Note(@PrimaryKey(autoGenerate = true)
                    val id: Int,
                    val title : String,
                    val body : String): Models(){
                    }

    @Entity(tableName = "Date")
    class Date(
        @PrimaryKey(autoGenerate =  true)
        val id:Int,
        val data: String):Models()
}
//@Entity(tableName = "notes")
//data class Notes(
//    @PrimaryKey(autoGenerate = true)
//    val id: Int,
//    val title : String,
//    val body : String
//)

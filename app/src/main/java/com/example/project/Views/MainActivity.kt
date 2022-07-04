package com.example.project.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project.NoteApplication
import com.example.project.R
import com.example.project.Repository.NotesRepository
import com.example.project.ViewModel.NoteViewModel
import com.example.project.ViewModel.NotesViewModelFactory
import com.example.project.databinding.ActivityMainBinding
import com.example.project.db.NotesDatabase

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var viewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val repository = (application as NoteApplication).noteRepo
        viewModel = ViewModelProvider(this, NotesViewModelFactory(repository)).get(NoteViewModel::class.java)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment, RecyclerFragment())
            commit()
        }
        binding.btnAdd.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, AddFragment())
                addToBackStack(null)
                commit()
            }
        }


    }
}
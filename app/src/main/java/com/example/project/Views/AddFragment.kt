package com.example.project.Views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.project.Model.Models
import com.example.project.NoteApplication
import com.example.project.R
import com.example.project.ViewModel.NoteViewModel
import com.example.project.ViewModel.NotesViewModelFactory


class AddFragment : Fragment() {
    lateinit var viewModel: NoteViewModel
    lateinit var title : EditText
    lateinit var body : EditText
    lateinit var submit : Button
    //lateinit var binding : FragmentAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        val repository = (activity?.application as NoteApplication).noteRepo
        viewModel = ViewModelProvider(this, NotesViewModelFactory(repository)).get(NoteViewModel::class.java)
        body = view.findViewById(R.id.body)
        title = view.findViewById(R.id.title)
        submit = view.findViewById(R.id.submit)

        submit.setOnClickListener{
            viewModel.addNote(Models.Note(0, title.text.toString(), body.text.toString()))
            //RecyclerFragment.adapter.addView2(Models.Date(0, "Note added"))
            Toast.makeText(context, "Note added ", Toast.LENGTH_LONG).show()
        }
        return view
    }
}
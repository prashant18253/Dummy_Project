package com.example.project.Views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.Model.Models
import com.example.project.NoteApplication
import com.example.project.R
import com.example.project.ViewModel.NoteViewModel
import com.example.project.ViewModel.NotesViewModelFactory
import com.example.project.onClickListener


class RecyclerFragment : Fragment(), onClickListener{

    lateinit var recyclerView: RecyclerView
    lateinit var viewModel: NoteViewModel
    lateinit var adapter : ViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_recycler, container, false)

        val repository = (activity?.application as NoteApplication).noteRepo
        viewModel = ViewModelProvider(this, NotesViewModelFactory(repository)).get(NoteViewModel::class.java)


        recyclerView = view.findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = ViewAdapter(this)
        recyclerView.adapter = adapter
        viewModel.getNotes().observe(requireActivity(), Observer {
            adapter.updateList(it)

        })
        return view
    }

    override fun ClickListener(position: Int) {
        var s =""
        when (adapter.getNote(position)){
            is Models.Note -> Toast.makeText(context, "cell ${position} clicked  of View 1", Toast.LENGTH_SHORT).show()
            is Models.Date -> Toast.makeText(context, "cell ${position} clicked of View 2", Toast.LENGTH_SHORT).show()
        }

    }

    override fun deleteListener(position: Int) {
        Toast.makeText(context, "Deleted ${position} clicked ", Toast.LENGTH_SHORT).show()
        viewModel.deleteNote(adapter.getNote(position) as Models.Note)
        //adapter.addView2(Models.Date(0,"Item Deleted"))
        //recyclerView.adapter!!.notifyDataSetChanged()
    }
}
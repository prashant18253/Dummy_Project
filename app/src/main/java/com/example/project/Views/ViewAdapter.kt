package com.example.project.Views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project.Model.Models
import com.example.project.R
import com.example.project.onClickListener

class ViewAdapter(private val cellClickListener: onClickListener): RecyclerView.Adapter<ViewAdapter.ViewHolders>() {
    var mList= mutableListOf<Models>()
    fun updateList(notes: List<Models>){
        mList.clear()
        mList.add(Models.Date(0, "This is view 2"))
        mList.addAll(notes)
        mList.add( Models.Date(0, "This is view 2"))
        notifyDataSetChanged()
    }
    fun getNote(pos: Int): Models{
        return mList.get(pos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolders {
        return when(viewType){
            R.layout.card_view_design -> ViewHolders.CardViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_view_design, parent, false))
            R.layout.date_view_design -> ViewHolders.DateViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.date_view_design, parent, false))
            else -> {throw IllegalArgumentException("Invalid ViewType Provided")}
        }
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_design, parent, false)
//        return ViewHolders(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolders, position: Int) {
        when(holder){
            is ViewHolders.CardViewHolder -> {
                val ItemsViewModel: Models = mList[position]
                when(ItemsViewModel) {
                    is Models.Note -> {
                        holder.title.setText(ItemsViewModel.title)
                        holder.body.setText(ItemsViewModel.body)
                    }
                }
                holder.btn.setOnClickListener{
                    cellClickListener.deleteListener(position)
                }
            }

            is ViewHolders.DateViewHolder->{
                val ItemViewModel = mList[position]
                when(ItemViewModel) {
                    is Models.Date -> {
                        holder.date.setText(ItemViewModel.data)
                    }
                }
            }
        }
        holder.itemView.setOnClickListener{
            cellClickListener.ClickListener(position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(mList[position]){
            is Models.Date -> R.layout.date_view_design
            is Models.Note -> R.layout.card_view_design
        }
    }

    sealed class ViewHolders(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        class CardViewHolder(ItemView: View) : ViewHolders(ItemView){
            val title: TextView  = ItemView.findViewById(R.id.title)
            val body: TextView  = ItemView.findViewById(R.id.body)
            var btn : Button = ItemView.findViewById(R.id.btnDelete)

        }

        class DateViewHolder(ItemView: View) : ViewHolders(ItemView){
            val date: TextView = ItemView.findViewById(R.id.date_text)
        }

    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        val title: TextView  = ItemView.findViewById(R.id.title)
        val body: TextView  = ItemView.findViewById(R.id.body)
        var btn : Button = ItemView.findViewById(R.id.btnDelete)

    }
}


//class ViewAdapter(private val cellClickListener: onClickListener): RecyclerView.Adapter<ViewAdapter.ViewHolder>() {
//    var mList = mutableListOf<Notes>()
//    fun updateList(notes: List<Notes>) {
//        mList.clear()
//        mList.addAll(notes)
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_design, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return mList.size
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val ItemsViewModel = mList[position]
//        holder.title.setText(ItemsViewModel.title)
//        holder.body.setText(ItemsViewModel.body)
//
//        holder.itemView.setOnClickListener {
//            cellClickListener.ClickListener(position)
//        }
//        holder.btn.setOnClickListener {
//            cellClickListener.deleteListener(position)
//        }
//
//
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        return super.getItemViewType(position)
//    }
//
//    sealed class ViewHolders(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
//        class CardViewHolder(ItemView: View) : ViewHolders(ItemView) {
//            val title: TextView = ItemView.findViewById(R.id.title)
//            val body: TextView = ItemView.findViewById(R.id.body)
//            var btn: Button = ItemView.findViewById(R.id.btnDelete)
//
//        }
//
//        class DateViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
//            val date: TextView = ItemView.findViewById(R.id.date_text)
//        }
//
//    }
//
//    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
//        val title: TextView = ItemView.findViewById(R.id.title)
//        val body: TextView = ItemView.findViewById(R.id.body)
//        var btn: Button = ItemView.findViewById(R.id.btnDelete)
//
//    }
//
//
//}
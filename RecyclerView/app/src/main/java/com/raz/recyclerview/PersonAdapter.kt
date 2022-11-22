package com.raz.recyclerview

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter(private val context:Context,val data:List<Person>,val OnItemClick:((Person,Int)->Unit)):RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    class PersonViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var vezeteknev:TextView=itemView.findViewById(R.id.list_item_vezeteknev)
        var keresztnev:TextView=itemView.findViewById(R.id.list_item_keresztnev)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val itemView=LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        return  PersonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
       val aktData:Person=data[position]
        holder.vezeteknev.text=aktData.vezeteknev
        holder.keresztnev.text=aktData.keresztnev
        holder.itemView.setOnClickListener{
            OnItemClick(aktData,position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
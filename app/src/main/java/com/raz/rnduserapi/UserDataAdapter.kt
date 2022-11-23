package com.raz.rnduserapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UserDataAdapter(val context: Context, val data:UserResults,val onItemClick:((UserData,Int)->Unit)):RecyclerView.Adapter<UserDataAdapter.UserDataViewHolder>() {
    class UserDataViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val userImage:ImageView=itemView.findViewById(R.id.list_item_picture)
        val userFirstname:TextView=itemView.findViewById(R.id.list_item_vezeteknev)
        val userLastname:TextView=itemView.findViewById(R.id.list_item_keresztnev)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDataViewHolder {
        val itemView=LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        return UserDataViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserDataViewHolder, position: Int) {
       val aktData:UserData=data.results[position]
        holder.userFirstname.text=aktData.name.first
        holder.userLastname.text=aktData.name.last
        holder.itemView.setOnClickListener {
            onItemClick(aktData,position)
        }
        Glide.with(context).load(aktData.picture.large).into(holder.userImage)
    }

    override fun getItemCount(): Int {
        return data.results.size
    }
}
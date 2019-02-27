package com.androidarchitecturecomponents.contentprovider

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.androidarchitecturecomponents.R

/**
 * Created by Ashutosh Ojha on 2/27/19.
 */
class TodoAdapter : RecyclerView.Adapter<TodoAdapter.MyViewHolder>() {
    lateinit var arrayList: ArrayList<Todo>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false))
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvTitle.text = arrayList.get(holder.adapterPosition).title
        holder.tvDesc.text = arrayList.get(holder.adapterPosition).desc
    }

    fun setData(arrayList: ArrayList<Todo>) {
        this.arrayList = arrayList
        notifyDataSetChanged()
    }


    class MyViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        val tvTitle = item.findViewById<TextView>(R.id.tvTitle)
        val tvDesc = item.findViewById<TextView>(R.id.tvDescription)
    }
}
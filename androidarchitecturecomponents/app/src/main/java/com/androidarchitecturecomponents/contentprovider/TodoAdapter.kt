package com.androidarchitecturecomponents.contentprovider

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.androidarchitecturecomponents.R

/**
 * Created by Ashutosh Ojha on 2/27/19.
 */
class TodoAdapter(callback: Callback) : RecyclerView.Adapter<TodoAdapter.MyViewHolder>() {
    var callback: Callback = callback
    lateinit var arrayList: ArrayList<Todo>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false))
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, pos: Int) {
        val position = holder.adapterPosition
        holder.tvTitle.text = arrayList.get(holder.adapterPosition).title
        holder.tvDesc.text = arrayList.get(holder.adapterPosition).desc

        holder.rlItem.setOnClickListener {
            callback.onEdit(position)
        }
        holder.ivDelete.setOnClickListener {
            callback.onDelete(position)
        }
    }

    fun setData(arrayList: ArrayList<Todo>) {



        this.arrayList = arrayList
        notifyDataSetChanged()
    }


    class MyViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        val tvTitle = item.findViewById<TextView>(R.id.tvTitle)
        val tvDesc = item.findViewById<TextView>(R.id.tvDescription)
        val ivDelete = item.findViewById<ImageView>(R.id.ivDelete)
        val rlItem = item.findViewById<RelativeLayout>(R.id.rlItem)
    }
}
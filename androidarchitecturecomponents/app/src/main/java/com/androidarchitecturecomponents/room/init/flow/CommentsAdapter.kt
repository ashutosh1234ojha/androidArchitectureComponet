package com.androidarchitecturecomponents.room.init.flow

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.androidarchitecturecomponents.R
import com.androidarchitecturecomponents.room.init.DataEntity

/**
 * Created by Ashutosh Ojha on 4/19/19.
 */
class CommentsAdapter(private val list:MutableList<DataEntity>): RecyclerView.Adapter<CommentsAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): MyViewHolder {


        val view=LayoutInflater.from(viewGroup.context).inflate(R.layout.item_comments,viewGroup,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(myViewHolder: MyViewHolder, p1: Int) {
        myViewHolder.tvComments.text="${p1+1}"+" "+list.get(p1).comments
    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvComments=view.findViewById<TextView>(R.id.tvComments)



    }
}
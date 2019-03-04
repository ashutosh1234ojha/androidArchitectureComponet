package com.androidarchitecturecomponents.contentprovider

import android.app.Activity
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.RelativeLayout
import android.widget.TextView


/**
 * Created by Ashutosh Ojha on 2/27/19.
 */
class TodoAdapter(callback: Callback) : RecyclerView.Adapter<TodoAdapter.MyViewHolder>() {
    var callback: Callback = callback
    lateinit var arrayList: ArrayList<Todo>
    lateinit var activity: Activity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        activity = parent.context as Activity
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(com.androidarchitecturecomponents.R.layout.item_todo, parent, false))
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onBindViewHolder(holder: MyViewHolder, pos: Int) {
        val position = holder.adapterPosition
        holder.tvTitle.text = arrayList.get(holder.adapterPosition).title
        holder.tvDesc.text = arrayList.get(holder.adapterPosition).desc

        holder.rlItem.setOnClickListener {
            callback.onEdit(position)
        }
        holder.ivMenu.setOnClickListener {
            //
            showPopUpMenu(holder.ivMenu, pos)
        }
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    private fun showPopUpMenu(view: View, pos: Int) {
        val popup = PopupMenu(activity, view,Gravity.RIGHT)
        // Inflate the menu from xml
        popup.inflate(com.androidarchitecturecomponents.R.menu.todo_menu)
        // Setup menu item selection
        popup.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                com.androidarchitecturecomponents.R.id.menu_edit -> {
                    callback.onEdit(pos)
                    true
                }
                com.androidarchitecturecomponents.R.id.menu_delete -> {
                    callback.onDelete(pos)
                    true
                }
                else -> false
            }
        }
        // Handle dismissal with: popup.setOnDismissListener(...);
        // Show the menu
        popup.show()

    }


    fun setData(arrayList: ArrayList<Todo>) {


        this.arrayList = arrayList
        notifyDataSetChanged()
    }


    class MyViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        val tvTitle = item.findViewById<TextView>(com.androidarchitecturecomponents.R.id.tvTitle)
        val tvDesc = item.findViewById<TextView>(com.androidarchitecturecomponents.R.id.tvDescription)
        val ivMenu = item.findViewById<ImageView>(com.androidarchitecturecomponents.R.id.ivMenu)
        val rlItem = item.findViewById<RelativeLayout>(com.androidarchitecturecomponents.R.id.rlItem)
    }
}
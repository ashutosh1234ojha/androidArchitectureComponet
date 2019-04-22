package com.androidarchitecturecomponents.room.init.flow

import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import com.androidarchitecturecomponents.R
import com.androidarchitecturecomponents.room.init.CommentsDatabase
import com.androidarchitecturecomponents.room.init.DataEntity


/**
 * Created by Ashutosh Ojha on 4/19/19.
 */
class CommentsActivity : AppCompatActivity() {

    private lateinit var list:MutableList<DataEntity>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        init()
    }

    fun init() {

        val rvComments = findViewById<RecyclerView>(R.id.rvComments)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val swipeRefresh = findViewById<SwipeRefreshLayout>(R.id.swipeRefresh)
        rvComments.layoutManager = LinearLayoutManager(applicationContext)

        list=CommentsDatabase.getInstance(this).commentsDao().getAllComment()

        val adapter = CommentsAdapter(list)
        rvComments.adapter = adapter

        btnAdd.setOnClickListener {
            startActivity(Intent(this,RoomActivity::class.java))
        }

        swipeRefresh.setOnClickListener {
            list=CommentsDatabase.getInstance(this).commentsDao().getAllComment()
            adapter.notifyDataSetChanged()

            swipeRefresh.isRefreshing=false
        }


    }
}
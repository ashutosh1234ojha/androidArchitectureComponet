package com.androidarchitecturecomponents.room.init.flow

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Button
import com.androidarchitecturecomponents.R
import com.androidarchitecturecomponents.room.init.CommentsDatabase
import com.androidarchitecturecomponents.room.init.CommentsEntity
import kotlinx.android.synthetic.main.activity_comments.*


/**
 * Created by Ashutosh Ojha on 4/19/19.
 */
class CommentsActivity : AppCompatActivity() {

    private val REQUEST_CODE = 100
    private lateinit var list: MutableList<CommentsEntity>
    private lateinit var adapter: CommentsAdapter
    private var userEmail = ""
    private var userId = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        userEmail = intent.getStringExtra("email")
        userId = intent.getIntExtra("user_id", -1)
        init()
    }

    fun init() {

//        val rvComments = findViewById<RecyclerView>(R.id.rvComments)
//        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val swipeRefresh = findViewById<SwipeRefreshLayout>(R.id.swipeRefresh)
        rvComments.layoutManager = LinearLayoutManager(applicationContext)

        list = CommentsDatabase.getInstance(this).commentsDao().getAllCommentForUser(userId)
//        list = CommentsDatabase.getInstance(this).commentsDao().getAllComment()

        adapter = CommentsAdapter(list)
        rvComments.adapter = adapter

        btnAdd.setOnClickListener {
            val intent = Intent(this, RoomActivity::class.java)
            intent.putExtra("email", userEmail)
            intent.putExtra("user_id", userId)
            startActivityForResult(intent, REQUEST_CODE)
        }

        swipeRefresh.setOnClickListener {
            list = CommentsDatabase.getInstance(this).commentsDao().getAllCommentForUser(userId)
            adapter.notifyDataSetChanged()

            swipeRefresh.isRefreshing = false
        }

        //We can use LiveData as we have done here or can use onActivityResult approach
        //Its for testing purpose. Normally we use LiveData in viewModal
        val observable = CommentsDatabase.getInstance(this).commentsDao().getAllCommentForUserLive(userId)
        observable.observe(this, Observer {
            list.clear()

            list.addAll(it as MutableList<CommentsEntity>)
            adapter.notifyDataSetChanged()
        })


    }

    //We can use getMethod of comment as we have done here or can use LiveData as above

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
//            list.clear()
//
//            list.addAll(CommentsDatabase.getInstance(this).commentsDao().getAllCommentForUser(userId))
//            adapter.notifyDataSetChanged()
//
//        }

    }
}
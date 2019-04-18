package com.androidarchitecturecomponents.room.init.flow

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import com.androidarchitecturecomponents.R
import com.androidarchitecturecomponents.room.init.CommentsDatabase

/**
 * Created by Ashutosh Ojha on 4/18/19.
 */
class RoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        init()
    }

    fun init() {
        val btnSave = findViewById<Button>(R.id.btnSave)
        val etComment = findViewById<EditText>(R.id.etComment)

        btnSave.setOnClickListener {
            CommentsDatabase.getInstance(this).commentsDao().addComment(etComment.text.toString())
        }
    }
}
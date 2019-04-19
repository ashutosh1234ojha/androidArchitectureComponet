package com.androidarchitecturecomponents.room.init.flow

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.androidarchitecturecomponents.R
import com.androidarchitecturecomponents.room.init.CommentsDatabase
import com.androidarchitecturecomponents.room.init.DataEntity

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
        val btnGet = findViewById<Button>(R.id.btnGet)
        val etComment = findViewById<EditText>(R.id.etComment)

        btnSave.setOnClickListener {


            val dataEntity = DataEntity()
            dataEntity.comments = etComment.text.toString()
            CommentsDatabase.getInstance(this).commentsDao().addComment(dataEntity)
        }

        btnGet.setOnClickListener {
            val list = CommentsDatabase.getInstance(this).commentsDao().getAllComment()

            for (d in list) {
                Log.d("ROOM_TABLE", d.comments + " Comments")

            }
        }

    }
}
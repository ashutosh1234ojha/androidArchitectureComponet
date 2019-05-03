package com.androidarchitecturecomponents.room.init.flow

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import com.androidarchitecturecomponents.R
import com.androidarchitecturecomponents.room.init.CommentsDatabase
import com.androidarchitecturecomponents.room.init.CommentsEntity

/**
 * Created by Ashutosh Ojha on 4/18/19.
 */
class RoomActivity : AppCompatActivity() {
    private var userEmail = ""
    private var userId = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        userEmail = intent.getStringExtra("email")
        userId = intent.getIntExtra("user_id", -1)
        init()
    }

    fun init() {
        val btnSave = findViewById<Button>(R.id.btnSave)
//        val btnGet = findViewById<Button>(R.id.btnGet)
        val etComment = findViewById<EditText>(R.id.etComment)

        btnSave.setOnClickListener {


            val dataEntity = CommentsEntity()
            dataEntity.comments = etComment.text.toString()
            dataEntity.user_id = userId
            CommentsDatabase.getInstance(this).commentsDao().addComment(dataEntity)
            setResult(Activity.RESULT_OK)
            finish()
        }

//        btnGet.setOnClickListener {
//            val list = CommentsDatabase.getInstance(this).commentsDao().getAllComment()
//
//            for (d in list) {
//                Log.d("ROOM_TABLE", d.comments + " Comments")
//
//            }
//        }

    }
}
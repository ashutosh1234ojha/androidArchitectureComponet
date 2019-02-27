package com.androidarchitecturecomponents.contentprovider

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import com.androidarchitecturecomponents.R
import kotlinx.android.synthetic.main.activity_todo.*
import java.util.*

/**
 * Created by Ashutosh Ojha on 2/27/19.
 */
class TodoActivity : AppCompatActivity() {
    private var dbHelper: TodoDbHelper? = null
    private var todoList = ArrayList<Todo>()
    private lateinit var rvTodo: RecyclerView
    private lateinit var todoAdapter: TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        init()
    }

    fun init() {
        rvTodo = findViewById(R.id.rvTodo)
        todoAdapter = TodoAdapter()
        rvTodo.adapter = todoAdapter
        rvTodo.layoutManager = LinearLayoutManager(applicationContext)


        dbHelper = TodoDbHelper(this)


        getTodoList()

        findViewById<Button>(R.id.btnSave).setOnClickListener {
            createNote(Todo(etTitle.text.toString(), etDesc.text.toString()))   //
        }

//        createNote(Todo("title", "description"))
    }

    private fun getTodoList() {
        todoList = dbHelper!!.allNotes
        todoAdapter.setData(todoList)
    }

    /**
     * Inserting new note in db and refreshing the list
     */
    private fun createNote(todo: Todo) {
        val id = dbHelper!!.insertTodo(todo)    // inserting note in db and getting newly inserted note id
        val new = dbHelper!!.getTodo(id)  // get the newly inserted note from db
        if (new != null) {
            todoList.add(0, new)    // adding new note to array list at 0 position
            todoAdapter!!.notifyDataSetChanged()  // refreshing the list
        }
    }
}
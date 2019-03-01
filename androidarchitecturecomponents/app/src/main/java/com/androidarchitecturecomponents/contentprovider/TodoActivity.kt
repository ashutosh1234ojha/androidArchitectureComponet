package com.androidarchitecturecomponents.contentprovider

import android.app.Dialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.androidarchitecturecomponents.R
import java.util.*

/**
 * Created by Ashutosh Ojha on 2/27/19.
 */
class TodoActivity : AppCompatActivity(), Callback {


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
        todoAdapter = TodoAdapter(this)
        rvTodo.adapter = todoAdapter
        val layoutManager = LinearLayoutManager(applicationContext)
        rvTodo.layoutManager = layoutManager
        val itemDecorator = DividerItemDecoration(this, layoutManager.orientation)
        rvTodo.addItemDecoration(itemDecorator)


        dbHelper = TodoDbHelper(this)


        getTodoList()

        findViewById<ImageView>(R.id.ivSave).setOnClickListener {
            showDialog(null, false)
        }
    }

    fun showDialog(todo: Todo?, isEdit: Boolean) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.layout_custom)
        val title = dialog.findViewById<EditText>(R.id.etTitle)
        val desc = dialog.findViewById<EditText>(R.id.etDesc)
        val btnSave = dialog.findViewById<Button>(R.id.btnSave)


        if(isEdit){
            title.setText(todo!!.title)
            desc.setText(todo!!.desc)
        }
        btnSave.setOnClickListener {
            if (isEdit) {
                todo!!.title=title.text.toString()
                todo.desc=desc.text.toString()
                dbHelper!!.updateTodo(todo)

                todoAdapter.notifyDataSetChanged()

            } else {
                createNote(Todo(title.text.toString(), desc.text.toString()))

            }
            dialog.dismiss()
        }
        dialog.show()
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

            todoList.add(0, new)    // adding new note to array list at 0 position
            todoAdapter.notifyDataSetChanged()  // refreshing the list

    }

    override fun onDelete(pos: Int) {

        if (dbHelper!!.deleteTodo(todoList[pos])) {
            todoList.remove(todoList.get(pos))
            todoAdapter.notifyDataSetChanged()

        }

    }

    override fun onEdit(pos: Int) {
        showDialog(todoList[pos], true)
        todoAdapter.setData(todoList)
        todoAdapter.notifyDataSetChanged()


    }
}
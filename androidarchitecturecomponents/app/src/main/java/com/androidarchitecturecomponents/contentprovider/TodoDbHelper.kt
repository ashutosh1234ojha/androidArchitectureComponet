package com.androidarchitecturecomponents.contentprovider

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by Ashutosh Ojha on 12/5/18.
 */
class TodoDbHelper(context: Context?) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        var DATABASE_NAME = "mytodolist.db"
        var DATABASE_VERSION = 1
    }


    override fun onCreate(db: SQLiteDatabase?) {

        /*
    * This String will contain a simple SQL statement that will create a table that will
    * cache our todo data.
    */

        val SQL_CREATE_TODO_TABLE = "CREATE TABLE " + TodoContract.TodoEntry.TABLE_NAME + " {" +

                TodoContract.TodoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TodoContract.TodoEntry.COLOUMN_DATE + " INTEGER NOT NULL, " +
                TodoContract.TodoEntry.COLOUMN_TASK + " TEXT NOT NULL, " +
                TodoContract.TodoEntry.COLOUMN_STATUS + "IINTEGER NOT NULL );"

        db?.execSQL(SQL_CREATE_TODO_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

}

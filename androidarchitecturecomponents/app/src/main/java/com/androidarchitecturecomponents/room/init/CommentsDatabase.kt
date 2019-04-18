package com.androidarchitecturecomponents.room.init

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

/**
 * Created by Ashutosh Ojha on 4/18/19.
 */
@Database(entities = [DataEntity::class], version = 1)
abstract class CommentsDatabase : RoomDatabase() {
    abstract fun commentsDao(): DataDao


    companion object {

        val DB_NAME: String = "DB_Comment"

        private var INSTANCE: CommentsDatabase? = null

        fun getInstance(context: Context): CommentsDatabase = INSTANCE
                ?: synchronized(this)
        {
            INSTANCE ?: buildDatabase(context).also { INSTANCE =it }
        }

        fun buildDatabase(context: Context): CommentsDatabase {
           return Room.databaseBuilder(context.applicationContext, CommentsDatabase::class.java, DB_NAME).allowMainThreadQueries().build()
        }
    }
}
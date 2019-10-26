package com.androidarchitecturecomponents.room.init

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.arch.persistence.room.migration.Migration
import android.content.Context

/**
 * Created by Ashutosh Ojha on 4/18/19.
 */

@Database(entities = [(CommentsEntity::class), (UserEntity::class)], version = 1)
@TypeConverters(Converters::class)
abstract class CommentsDatabase : RoomDatabase() {
    abstract fun commentsDao(): DataDao
    abstract fun userDao(): UserDao


    companion object {

        val DB_NAME: String = "DB_Comment"

        private var INSTANCE: CommentsDatabase? = null

        fun getInstance(context: Context): CommentsDatabase = INSTANCE
                ?: synchronized(this)
                {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

        fun buildDatabase(context: Context): CommentsDatabase {
            return Room.databaseBuilder(context.applicationContext, CommentsDatabase::class.java, DB_NAME)
                    .addMigrations(MIGRATION_1_2, MIGRATION_2_3).allowMainThreadQueries().build()
        }

        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Since we didn't alter the table, there's nothing else to do here.
            }
        }

        val MIGRATION_2_3: Migration = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE users " + " ADD COLUMN last_update INTEGER")
            }
        }

    }




}
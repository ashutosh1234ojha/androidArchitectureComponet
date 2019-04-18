package com.androidarchitecturecomponents.room.init

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update

/**
 * Created by Ashutosh Ojha on 4/15/19.
 */
@Dao()
interface DataDao {

    @Insert()
    fun addComment(comment: String)

    @Update()
    fun updateComment(pos: Int)


    @Query("select * from tb_comments" )
    fun getAllComment():MutableList<DataEntity>


}
package com.androidarchitecturecomponents.room.init

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

/**
 * Created by Ashutosh Ojha on 4/15/19.
 */
@Dao
interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addComment(comment: CommentsEntity)

    @Update
    fun updateComment(comment: CommentsEntity)


    @Query("select * from tb_comments")
    fun getAllComment(): MutableList<CommentsEntity>

    @Query("select * from tb_comments where user_id =:user_id")
    fun getAllCommentForUser(user_id: Int): MutableList<CommentsEntity>

    @Query("select * from tb_comments where user_id =:user_id")
    fun getAllCommentForUserLive(user_id: Int): LiveData<MutableList<CommentsEntity>>
//
//    @Insert
//    fun addUser(comment: UserEntity)
//
//
//    @Query("select * from tb_user where email=:email and password=:password ")
//    fun isCustomerExist(email: String, password: String): UserEntity
}
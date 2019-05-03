package com.androidarchitecturecomponents.room.init

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

/**
 * Created by Ashutosh Ojha on 4/15/19.
 */
@Dao
interface UserDao {

//    @Insert
//    fun addComment(comment: CommentsEntity)
//
//    @Update
//    fun updateComment(comment: CommentsEntity)
//
//
//    @Query("select * from tb_comments")
//    fun getAllComment(): MutableList<CommentsEntity>
//
//    @Query("select * from tb_comments where user_id =:user_id")
//    fun getAllCommentForUser(user_id: Int): MutableList<CommentsEntity>

    @Insert
    fun addUser(comment: UserEntity)


    @Query("select * from tb_user where email=:email and password=:password ")
    fun isCustomerExist(email: String, password: String): UserEntity
}
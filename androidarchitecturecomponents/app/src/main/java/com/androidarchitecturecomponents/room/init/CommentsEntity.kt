package com.androidarchitecturecomponents.room.init

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Ashutosh Ojha on 4/15/19.
 */

/**
 * we can remove the foreignKey's from below. Its for  information purpose only
 */
@Entity(
        tableName = "tb_comments",
        foreignKeys = [ForeignKey(
                entity = UserEntity::class,
                parentColumns = arrayOf("user_id"),
                childColumns = arrayOf("user_id"))]
)

//@Entity( tableName = "tb_comments")
class CommentsEntity {
    @PrimaryKey(autoGenerate = true)
    var comments_id: Int = 0
    var comments: String = ""
    var user_id: Int = 0
}
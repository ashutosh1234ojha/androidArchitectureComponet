package com.androidarchitecturecomponents.room.init

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Ashutosh Ojha on 4/15/19.
 */
@Entity(tableName = "tb_comments")
class DataEntity{
        @PrimaryKey(autoGenerate = true)
        var count: Int = 0
        var comments: String=""
}
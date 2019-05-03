package com.androidarchitecturecomponents.room.init

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Ashutosh Ojha on 4/15/19.
 */
@Entity(tableName = "tb_user")
class UserEntity {
    @PrimaryKey(autoGenerate = true)
    var user_id: Int = 0
    var email: String = ""
    var password: String = ""

    //For testing only. It test's how to save non primitive value in Room
    var person:Person?=null
}
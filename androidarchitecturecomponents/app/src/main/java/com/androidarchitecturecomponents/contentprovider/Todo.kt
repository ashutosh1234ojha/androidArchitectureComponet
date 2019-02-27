package com.androidarchitecturecomponents.contentprovider

import java.io.Serializable

/**
 * Created by Ashutosh Ojha on 2/27/19.
 */
class Todo(var name: String)  :Serializable {
    var id: Int? = null
    var title: String? = null
    var desc: String? = null
    var timeStamp: String? = null

    constructor(id: Int, title: String, desc: String, timeStamp: String) : this(title) {
        this.id = id
        this.title = title
        this.desc = desc
        this.timeStamp = timeStamp
    }

    constructor( title: String, desc: String) : this(title) {
        this.title = title
        this.desc = desc
    }

}
package com.androidarchitecturecomponents.contentprovider

/**
 * Created by Ashutosh Ojha on 3/1/19.
 */
interface Callback {
    fun onDelete(pos: Int)
    fun onEdit(pos: Int)
}
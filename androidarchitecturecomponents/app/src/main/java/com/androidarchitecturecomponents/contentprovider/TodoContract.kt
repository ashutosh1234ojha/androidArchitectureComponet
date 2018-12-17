package com.androidarchitecturecomponents.contentprovider

import android.net.Uri
import android.provider.BaseColumns

/**
 * Created by Ashutosh Ojha on 12/5/18.
 */
class TodoContract {

    companion object {
        /*
    * The "Content authority" is a name for the entire content provider, similar to the
    * relationship between a domain name and its website. A convenient string to use for the
    * content authority is the package name for the app, which is guaranteed to be unique on the
    * Play Store.
    */
        val CONTENT_AUTHORITY = "com.androidarchitecturecomponents"

        /*
         * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
         * the content provider for Sunshine.
         */
        val BASE_CONTENT_URI = Uri.parse("content://$CONTENT_AUTHORITY")

    }

    class TodoEntry : BaseColumns {

        companion object {
            var _ID: String = "id"
            var TABLE_NAME: String = "todo"
            var COLOUMN_DATE: String = "date"
            var COLOUMN_TASK: String = "task"
            var COLOUMN_STATUS: String = "status"
        }


        /* The base CONTENT_URI used to query the Todo table from the content provider */
        val CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build()


        fun buildTodoUriWithId(id: Long): Uri {
            return BASE_CONTENT_URI.buildUpon().appendPath(id.toString()).build()
        }

    }
}
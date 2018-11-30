package com.androidarchitecturecomponents.workermanager

import android.util.Log
import androidx.work.Worker

/**
 * Created by Ashutosh Ojha on 11/29/18.
 */
class MyWorker : Worker() {
    override fun doWork(): WorkerResult {
        //Do the things that you need to change

        while (true){
            Log.d("Tag","inside while")
        }
    }
}
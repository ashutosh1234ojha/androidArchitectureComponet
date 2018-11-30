package com.androidarchitecturecomponents

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.androidarchitecturecomponents.workermanager.MyWorker
import com.lifecycle.LifecycleMain



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Add Lifecycle Observer
        lifecycle.addObserver(LifecycleMain.getInstance())


        workManager()


    }

    private fun workManager() {
        var oneTimeWorkRequest=OneTimeWorkRequest.Builder(MyWorker::class.java).build()

        WorkManager.getInstance().enqueue(oneTimeWorkRequest)


    }

    override fun onDestroy() {
        super.onDestroy()

        // Remove Lifecycle Observer
        lifecycle.removeObserver(LifecycleMain.getInstance())

    }
}

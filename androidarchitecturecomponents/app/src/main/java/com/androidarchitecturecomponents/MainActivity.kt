package com.androidarchitecturecomponents

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lifecycle.LifecycleMain

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Add Lifecycle Observer
        lifecycle.addObserver(LifecycleMain.getInstance())


    }

    override fun onDestroy() {
        super.onDestroy()

        // Remove Lifecycle Observer
        lifecycle.removeObserver(LifecycleMain.getInstance())

    }
}

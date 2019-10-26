package com.androidarchitecturecomponents.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.androidarchitecturecomponents.R

class BroadcastActivity : AppCompatActivity() {

    val myBoradcast = MyInnerBroadcast()
    var textView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast)

        textView = findViewById(R.id.msg) as TextView
        findViewById<Button>(R.id.send).setOnClickListener {
            val intent = Intent("com.androidarchitecturecomponents.action")
            intent.putExtra("com.androidarchitecturecomponents.msg", "hello jerry")
            sendBroadcast(intent)
        }
    }


    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter("com.androidarchitecturecomponents.action")
        registerReceiver(myBoradcast, intentFilter)

    }


    override fun onStop() {
        super.onStop()
        unregisterReceiver(myBoradcast)
    }


    inner class MyInnerBroadcast : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if ("com.androidarchitecturecomponents.action".equals(intent?.action)) {
//                Toast.makeText(context, "Boot Completed", Toast.LENGTH_SHORT).show()
                textView?.text = intent?.getStringExtra("com.androidarchitecturecomponents.msg")
            }

        }

    }
}
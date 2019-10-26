package com.androidarchitecturecomponents.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class MyBoradcast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        if("com.androidarchitecturecomponents.action".equals(intent?.action)){
            Toast.makeText(context,"Boot Completed",Toast.LENGTH_SHORT).show()
        }


    }
}
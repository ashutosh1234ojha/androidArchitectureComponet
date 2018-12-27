package com.androidarchitecturecomponents.download

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.androidarchitecturecomponents.R


/**
 * Created by Ashutosh Ojha on 12/27/18.
 */
class DownloadActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download)

        findViewById<Button>(R.id.btnDownload).setOnClickListener {
            val intent = Intent(this, DownloadService::class.java)
            intent.putExtra("downloadUrl", "http://ichef.bbci.co.uk/onesport/cps/480/cpsprodpb/11136/production/_95324996_defoe_rex.jpg")
            intent.putExtra("receiver", DownloadReceiver(Handler()))
            startService(intent)
        }
    }
}
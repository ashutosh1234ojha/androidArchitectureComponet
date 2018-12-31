package com.androidarchitecturecomponents.download

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.ResultReceiver
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import com.androidarchitecturecomponents.R


/**
 * Created by Ashutosh Ojha on 12/27/18.
 */
class DownloadActivity : AppCompatActivity() {

    lateinit var progressBar: ProgressBar
    lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download)


        progressBar = findViewById(R.id.progressBar)
        imageView = findViewById(R.id.imageView)

        findViewById<Button>(R.id.btnDownload).setOnClickListener {
            val intent = Intent(this, DownloadService::class.java)
            intent.putExtra("downloadUrl", "https://api.androidhive.info/progressdialog/hive.jpg")
//            intent.putExtra("downloadUrl", "http://ichef.bbci.co.uk/onesport/cps/480/cpsprodpb/11136/production/_95324996_defoe_rex.jpg")
            intent.putExtra("receiver", DownloadReceiver(Handler()))
            startService(intent)

        }
    }

    inner class DownloadReceiver(handler: Handler) : ResultReceiver(handler) {

        override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {
            super.onReceiveResult(resultCode, resultData)

            if (resultCode == DownloadService.UPDATE_PROGRESS) {
                val progress = resultData?.getInt("progress")

                if (progress != null) {
                    progressBar.setProgress(progress)
                }


                if(progress==100){
                    val imagePath = Environment.getExternalStorageDirectory().toString() + "/downloadedfile.jpg"
                    imageView.setImageDrawable(Drawable.createFromPath(imagePath))
                }

            }
        }
    }
}
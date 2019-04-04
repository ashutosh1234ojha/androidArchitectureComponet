package com.androidarchitecturecomponents.download

import android.app.DownloadManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.*
import android.support.v4.app.NotificationCompat
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

    lateinit var notificationBuilder: NotificationCompat.Builder
    lateinit var notificationManager: NotificationManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download)


        progressBar = findViewById(R.id.progressBar)
        imageView = findViewById(R.id.imageView)

        findViewById<Button>(R.id.btnDownload).setOnClickListener {

            //TODO uncomment to use service
          //  downloadUsingService()

            downloadUsingDownloadManager()


        }

    }

    private fun downloadUsingDownloadManager() {

        val url = "https://api.androidhive.info/progressdialog/hive.jpg"
        val request = DownloadManager.Request(Uri.parse(url))
        request.setDescription("Downloading image")
        request.setDescription("Android")

        request.allowScanningByMediaScanner()
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "android.ext")
        val manager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        manager.enqueue(request)

    }

    private fun downloadUsingService() {
        val intent = Intent(this, DownloadService::class.java)
        intent.putExtra("downloadUrl", "https://api.androidhive.info/progressdialog/hive.jpg")
        intent.putExtra("receiver", DownloadReceiver(Handler()))
        startService(intent)

        setNotification("Image downloading", "Download in progress")
    }

    inner class DownloadReceiver(handler: Handler) : ResultReceiver(handler) {

        override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {
            super.onReceiveResult(resultCode, resultData)

            if (resultCode == DownloadService.UPDATE_PROGRESS) {
                val progress = resultData?.getInt("progress")

                if (progress != null) {
//                    progressBar.setProgress(progress)
                    notificationBuilder.setProgress(100, progress, false)
//                    notificationManager.notify(1, notificationBuilder.build())


                }


                if (progress == 100) {
                    val imagePath = Environment.getExternalStorageDirectory().toString() + "/downloadedfile.jpg"
                    imageView.setImageDrawable(Drawable.createFromPath(imagePath))

                    notificationBuilder.setContentText("Upload Complete");
                    notificationManager.notify(1, notificationBuilder.build());
                }

            }
        }
    }

    private fun setNotification(title: String, msg: String) {
        notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel("default", "Download", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        notificationBuilder = NotificationCompat.Builder(applicationContext, "")
                .setContentTitle(title)
                .setContentText(msg)
                .setSmallIcon(R.mipmap.ic_launcher)

        notificationManager.notify(1, notificationBuilder.build())

    }

    fun isDownloadManagerAvailable(context: Context): Boolean {

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            true
        } else false
    }
}
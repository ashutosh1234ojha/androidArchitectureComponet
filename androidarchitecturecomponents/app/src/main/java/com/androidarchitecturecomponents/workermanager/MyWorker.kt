package com.androidarchitecturecomponents.workermanager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.support.v4.app.NotificationCompat
import androidx.work.Worker
import com.androidarchitecturecomponents.R

/**
 * Created by Ashutosh Ojha on 11/29/18.
 */
class MyWorker : Worker() {
    override fun doWork(): WorkerResult {


        setNotification("Workmanager", "Send by work manager")

        try {
            Thread.sleep(5000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }


        return WorkerResult.SUCCESS

    }

    private fun setNotification(title: String, msg: String) {
        val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel("default", "Work manager", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        val notificationBuilder = NotificationCompat.Builder(applicationContext, "")
                .setContentTitle(title)
                .setContentText(msg)
                .setSmallIcon(R.mipmap.ic_launcher)

        notificationManager.notify(1, notificationBuilder.build())

    }
}
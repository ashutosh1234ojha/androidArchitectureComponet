package com.androidarchitecturecomponents.download

import android.app.IntentService
import android.content.Intent
import android.os.Bundle
import android.os.ResultReceiver
import java.io.BufferedInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.net.URL



/**
 * Created by Ashutosh Ojha on 12/27/18.
 */
class DownloadService : IntentService("Download service") {

    val UPDATE_PROGRESS = 8344
    override fun onHandleIntent(intent: Intent?) {
        val downloadUrl = intent?.getStringExtra("downloadUrl")
        val resultReceiver = intent?.getParcelableExtra<ResultReceiver>("receiver")

        try {
            val url = URL(downloadUrl)
            val connectionUrl = url.openConnection()
            connectionUrl.connect()

            val fileLength = connectionUrl.contentLength

            val inputStream = BufferedInputStream(connectionUrl.getInputStream())
            val outputStream = FileOutputStream("/sdcard/BarcodeScanner-debug.apk")

            val data = ByteArray(1024)

            var total = 0
            var count = 0

            count = inputStream.read(data)

            while (count != -1) {
                count = inputStream.read(data)
                total += count

                val resultData = Bundle()
                resultData.putInt("progress", (total * 100 / fileLength))

                resultReceiver?.send(UPDATE_PROGRESS, resultData)
                outputStream.write(data, 0, count)


            }
            outputStream.flush()
            outputStream.close()
            inputStream.close()
        } catch (exception: IOException) {
            exception.printStackTrace()
        }

        val resultBundle = Bundle()
        resultBundle.putInt("progress", 100)
        resultReceiver?.send(UPDATE_PROGRESS, resultBundle)

    }


}
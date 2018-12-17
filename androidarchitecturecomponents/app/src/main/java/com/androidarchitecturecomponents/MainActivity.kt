package com.androidarchitecturecomponents

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.androidarchitecturecomponents.workermanager.MyWorker
import com.lifecycle.LifecycleMain
import kotlinx.android.synthetic.main.activity_main.*




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Add Lifecycle Observer
        lifecycle.addObserver(LifecycleMain.getInstance())

        val btnWorkManager=findViewById<Button>(R.id.btnWorkManager)
        btnWorkManager.setOnClickListener {
            workManager()
        }



    }

    private fun workManager() {
        val oneTimeWorkRequest=OneTimeWorkRequest.Builder(MyWorker::class.java).build()

        WorkManager.getInstance().enqueue(oneTimeWorkRequest)


        WorkManager.getInstance().getStatusById(oneTimeWorkRequest.id).observe(this, Observer {
            tvWorkManagerStatus.append("SimpleWorkRequest ${it?.state?.name}")

            if(it!=null&&it.state.isFinished){
                tvWorkManagerStatus.append("SimpleWorkRequest ${it?.state?.name}")

            }

        })



    }

    override fun onDestroy() {
        super.onDestroy()

        // Remove Lifecycle Observer
        lifecycle.removeObserver(LifecycleMain.getInstance())

    }
}

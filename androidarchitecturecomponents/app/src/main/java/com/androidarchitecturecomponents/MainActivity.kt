package com.androidarchitecturecomponents

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.androidarchitecturecomponents.workermanager.MyWorker
import com.lifecycle.LifecycleMain
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val activity:AppCompatActivity?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Add Lifecycle Observer
        lifecycle.addObserver(LifecycleMain.getInstance())

        val btnWorkManager = findViewById<Button>(R.id.btnWorkManager)
        btnWorkManager.setOnClickListener {
            workManager()
        }

        val btnWorkManagerCancel = findViewById<Button>(R.id.btnWorkManagerCancel)
        btnWorkManagerCancel.setOnClickListener {


            WorkManager.getInstance().cancelAllWorkByTag("simple_work");
        }


        val observable1 = Observable.create(ObservableOnSubscribe<Int> { })
        test()

        val radioGroup:RadioGroup=findViewById(R.id.rg)
        var numberOfPlayers: Int = 0
        radioGroup.setOnCheckedChangeListener { group, checkedId ->

            val chosen = activity?.findViewById<RadioButton>(checkedId)?.text
            numberOfPlayers = chosen.toString().toInt()

        }


    }

    private fun workManager() {
        var constraints = Constraints.Builder()
                .setRequiresCharging(true).build() as Constraints

        val oneTimeWorkRequest = OneTimeWorkRequest.Builder(MyWorker::class.java)
                .setConstraints(constraints)
                .addTag("simple_work")
                .build()

        WorkManager.getInstance().enqueue(oneTimeWorkRequest)


        WorkManager.getInstance().getStatusById(oneTimeWorkRequest.id).observe(this, Observer {
            tvWorkManagerStatus.append("SimpleWorkRequest ${it?.state?.name}")

            if (it != null && it.state.isFinished) {
                tvWorkManagerStatus.append("SimpleWorkRequest ${it.state.name}")
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()

        // Remove Lifecycle Observer
        lifecycle.removeObserver(LifecycleMain.getInstance())

    }

    fun test() {

        val person = Person()
        print(person.name)
        print(person.age)

        with(person){
            print(name)
            print(age)
        }

        person.also  {
            print(it.name)
        }

    }

    class Person {
        var name: String? = null
        var age: Int? = null
    }








}

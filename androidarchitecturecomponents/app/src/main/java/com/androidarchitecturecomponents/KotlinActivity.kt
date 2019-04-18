package com.androidarchitecturecomponents

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by Ashutosh Ojha on 4/12/19.
 */
class KotlinActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.layout_custom)
//
//        findViewById<Button>(R.id.btnSave).setOnClickListener {
//
//            rotate()
//        }
        rotate()

    }

    fun rotate(){
        val input=ArrayList<Int>()
        input.add(1)
        input.add(2)

        for( a in input){

            print("NumberMy  $a")
        }
    }

}
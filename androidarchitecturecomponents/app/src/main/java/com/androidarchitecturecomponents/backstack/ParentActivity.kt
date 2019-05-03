package com.androidarchitecturecomponents.backstack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import com.androidarchitecturecomponents.R

/**
 * Created by Ashutosh Ojha on 2019-05-01.
 */
class ParentActivity : AppCompatActivity(), Callback {


    lateinit var btnTabA: Button
    lateinit var btnTabB: Button
    var positionA: Int = 0
    var positionB: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent)


        init()
    }

    fun init() {
        btnTabA = findViewById(R.id.btnTabA)
        btnTabB = findViewById(R.id.btnTabB)

        Log.d("backStackEntryCount", "" + supportFragmentManager.backStackEntryCount + "  init")
//        btnTabA.performClick()
        btnTabA.setOnClickListener {

            if(positionA==0){
                supportFragmentManager.beginTransaction().replace(R.id.flContainer, ListAFragment(this)).addToBackStack(null).commit()
                Log.d("backStackEntryCount", "" + supportFragmentManager.backStackEntryCount + " first add")
            }else{
                supportFragmentManager.beginTransaction().replace(R.id.flContainer, ListAFragment(this)).addToBackStack(null).commit()

                supportFragmentManager.beginTransaction().replace(R.id.flContainer, DetailsAFragment()).addToBackStack(null).commit()
                Log.d("backStackEntryCount", "" + supportFragmentManager.backStackEntryCount + " first add")
            }



        }
        btnTabB.setOnClickListener {

            if(positionA==0){
                supportFragmentManager.beginTransaction().replace(R.id.flContainer, ListBFragment(this)).addToBackStack(null).commit()
                Log.d("backStackEntryCount", "" + supportFragmentManager.backStackEntryCount + " second add")
            }else{
                supportFragmentManager.beginTransaction().replace(R.id.flContainer, ListBFragment(this)).addToBackStack(null).commit()
                Log.d("backStackEntryCount", "" + supportFragmentManager.backStackEntryCount + " second add")

                supportFragmentManager.beginTransaction().replace(R.id.flContainer, DetailsBFragment()).addToBackStack(null).commit()
                Log.d("backStackEntryCount", "" + supportFragmentManager.backStackEntryCount + " first add")
            }




        }
    }

    override fun onClick(one: Int) {

        if (one == 1) {
            positionA = 1
            supportFragmentManager.beginTransaction().replace(R.id.flContainer, DetailsAFragment()).addToBackStack(null).commit()
            Log.d("backStackEntryCount", "" + supportFragmentManager.backStackEntryCount + "onclick first add")


        } else {
            positionB = 1

            supportFragmentManager.beginTransaction().replace(R.id.flContainer, DetailsBFragment()).addToBackStack(null).commit()
            Log.d("backStackEntryCount", "" + supportFragmentManager.backStackEntryCount + "onclick second add")


        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Log.d("backStackEntryCount", "" + supportFragmentManager.backStackEntryCount + " onBackPress")

        if( supportFragmentManager.backStackEntryCount==4){

        }

    }
}
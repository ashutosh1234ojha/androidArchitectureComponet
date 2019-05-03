package com.androidarchitecturecomponents.backstack

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.androidarchitecturecomponents.R

/**
 * Created by Ashutosh Ojha on 2019-05-01.
 */
@SuppressLint("ValidFragment")
class ListBFragment : Fragment {

     var callback: Callback

    @SuppressLint("ValidFragment")
    constructor(parentActivity: ParentActivity) : super() {

        callback = parentActivity
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_backstack, container, false)
        view.findViewById<TextView>(R.id.tvLabel).setText("ListBFragment")
        view.findViewById<TextView>(R.id.tvLabel).setOnClickListener {
            callback.onClick(2)
        }

        return view
    }
}
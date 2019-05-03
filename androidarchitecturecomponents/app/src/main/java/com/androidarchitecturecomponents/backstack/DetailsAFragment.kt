package com.androidarchitecturecomponents.backstack

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
class DetailsAFragment :Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_backstack, container, false)
        view.findViewById<TextView>(R.id.tvLabel).setText("DetailsAFragment")
        return view
    }
}
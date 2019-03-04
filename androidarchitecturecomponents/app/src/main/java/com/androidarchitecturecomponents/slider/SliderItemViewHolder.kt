package com.androidarchitecturecomponents.slider

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.androidarchitecturecomponents.R

/**
 * Created by nbtk on 5/4/18.
 */
class SliderItemViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

    var screenWidth: Int=0
    val tvItem: TextView? = itemView?.findViewById(R.id.tv_item)

    init {
        tvItem!!.width = ScreenUtils.getScreenWidth(itemView!!.context) / 5
//        tvItem!!.height=getScreenWidth(itemView!!.context)/2
    }

//    llImg = (LinearLayout) itemView.findViewById(R.id.llImg);



}
package com.androidarchitecturecomponents.paging

import com.google.gson.annotations.SerializedName

/**
 * Created by Ashutosh Ojha on 12/4/18.
 */
data class News(@SerializedName("urlToImage") val image: String, val title: String)

package com.lifecycle

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log

/**
 * Created by Ashutosh Ojha on 11/26/18.
 *
 * https://android.jlelse.eu/is-your-android-library-lifecycle-aware-127629d32dcc
 */
object LifecycleMain : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun init() {

        Log.d("Tag", "ankur")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun cleanUp() {
        Log.d("Tag", "on destroy")

    }

    fun getInstance(): LifecycleMain {
        return this
    }

}
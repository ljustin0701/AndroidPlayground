package com.example.justinli.architecturecomponents

import android.arch.lifecycle.LifecycleObserver
import android.content.Context
import android.net.ConnectivityManager

class ConnectionManager(context : Context) : LifecycleObserver {

    private val connectivityManager: ConnectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

}
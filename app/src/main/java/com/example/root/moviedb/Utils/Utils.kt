package com.example.root.moviedb.Utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by Juan Arango on 4/1/18.
 */
object Utils{
    fun isNetworkAvailable(context: Context): Boolean {
        try {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnected
        } catch (e: Exception) {
            return false
        }

    }
}
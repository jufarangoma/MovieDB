package com.example.root.moviedb.Utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.v4.content.LocalBroadcastManager

/**
 * Created by Juan Arango on 4/1/18.
 */
class NetworkStateReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == ConnectivityManager.CONNECTIVITY_ACTION) {
            val networkInfo = intent.getParcelableExtra<NetworkInfo>(ConnectivityManager.EXTRA_NETWORK_INFO)
            if (networkInfo != null && networkInfo.detailedState == NetworkInfo.DetailedState.CONNECTED) {

            } else if (networkInfo != null && networkInfo.detailedState == NetworkInfo.DetailedState.DISCONNECTED) {
                val i = Intent("state internet")
                i.putExtra(Constants.Key.Action, Constants.Value.NOINTERNET)
                LocalBroadcastManager.getInstance(context)
                        .sendBroadcast(i)
            }
        }
    }
}
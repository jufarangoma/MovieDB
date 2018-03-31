package com.example.root.moviedb.Views.Base

import android.app.ProgressDialog
import android.content.BroadcastReceiver
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AppCompatActivity
import com.example.root.moviedb.App.AppController
import com.example.root.moviedb.R

/**
 * Created by Juan Arango on 3/30/18.
 */

open class BaseView(): AppCompatActivity(){

    private var progressDialog: ProgressDialog? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*mNotificationsReceiver= object: BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                showDialog(Constants.DialogType.ERROR,"Error","Perdimos conexion a internet",null,Constants.DialogTag.ok)
            }
        }*/
    }

    /*override fun onResume() {
        //App.mContext = this
        super.onResume()
        LocalBroadcastManager.getInstance(this@BaseView)
                .registerReceiver(mNotificationsReceiver, IntentFilter("state internet"))
    }

    override fun onDestroy() {
        // Unregister since the activity is about to be closed.
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mNotificationsReceiver)
        super.onDestroy()
    }*/

    fun showProgress(titleDialog :String?){
        if(progressDialog!=null){
            closeProgress()
        }
        progressDialog= ProgressDialog(this, R.style.AppCompatAlertDialogStyle)
        progressDialog!!.setMessage(titleDialog)
        progressDialog!!.setCancelable(true)
        progressDialog!!.show()
    }

    fun closeProgress(){
        if (progressDialog != null && progressDialog!!.isShowing()) {
            progressDialog!!.dismiss()
            progressDialog=null
        }
    }
}
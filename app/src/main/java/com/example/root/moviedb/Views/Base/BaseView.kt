package com.example.root.moviedb.Views.Base

import android.app.DialogFragment
import android.app.ProgressDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AppCompatActivity
import com.example.root.moviedb.R

/**
 * Created by Juan Arango on 4/1/18.
 */

open class BaseView(): AppCompatActivity(){

    var currentDialog: DialogFragment? = null
    private var progressDialog: ProgressDialog? =null
    var mNotificationsReceiver: BroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mNotificationsReceiver= object: BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                // Get extra data included in the Intent
                showDialog()
            }
        }
    }

    override fun onResume() {
        //App.mContext = this
        super.onResume()
        LocalBroadcastManager.getInstance(this@BaseView)
                .registerReceiver(mNotificationsReceiver!!, IntentFilter("state internet"))
    }

    override fun onDestroy() {
        // Unregister since the activity is about to be closed.
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mNotificationsReceiver!!)
        super.onDestroy()
    }
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

    open fun showDialog() {
        closeDialog()

        val ft = fragmentManager.beginTransaction()
        ft.addToBackStack(null)
        currentDialog = CustomDialog()
        currentDialog!!.show(ft,"alert")

    }

    protected fun closeDialog() {
        if (currentDialog != null )
            currentDialog!!.dismiss()
        if (progressDialog != null && progressDialog!!.isShowing())
            progressDialog!!.dismiss()
    }


    fun onFailed(string: String) {
        showDialog()
    }

}
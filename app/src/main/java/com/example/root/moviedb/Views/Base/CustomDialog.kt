package com.example.root.moviedb.Views.Base

import android.app.DialogFragment
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.example.root.moviedb.R
import kotlinx.android.synthetic.main.fragment_alert.*

/**
 * Created by Juan Arango on 4/1/18.
 */
class CustomDialog : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val viewRoot: View
        viewRoot = inflater!!.inflate(R.layout.fragment_alert, container, false)
        return viewRoot
    }

    override fun onResume() {
        super.onResume()
        btn_exit.setOnClickListener {
            dialog.dismiss()
        }
    }

}
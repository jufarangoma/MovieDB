package com.example.root.moviedb.Views.Activity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.example.root.moviedb.ViewModel.MovieViewModel
import com.example.root.moviedb.Views.Base.BaseView
import java.util.*
import android.databinding.DataBindingUtil
import android.provider.SyncStateContract
import android.support.v7.widget.RecyclerView
import com.example.root.moviedb.R
import com.example.root.moviedb.Utils.Constants
import com.example.root.moviedb.databinding.ActivityHomeBinding


/**
 * Created by Juan Arango on 3/30/18.
 */
class MovieActivity: BaseView(), Observer{

    var movieViewModel: MovieViewModel?=null
    var activityHomebinding: ActivityHomeBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        callService()
        initBinding()
        setListofMoview(activityHomebinding!!.rvListMovies)
    }

    fun callService(){
        val querie: HashMap<String, String> = HashMap()
        querie.put(Constants.Key.API_KEY, Constants.Value.API_KEY)
        movieViewModel = MovieViewModel(this,Constants.Url.DISCOVER,querie)
    }

    fun initBinding(){
        activityHomebinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        activityHomebinding!!.movieViewModel = movieViewModel
    }

    private fun setListofMoview(rvListMovies: RecyclerView) {

    }

    override fun update(p0: Observable?, p1: Any?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
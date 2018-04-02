package com.example.root.moviedb.Views.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.root.moviedb.ViewModel.MovieViewModel

import java.util.*
import android.databinding.DataBindingUtil
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.WindowManager
import android.widget.LinearLayout
import com.example.root.moviedb.R
import com.example.root.moviedb.Utils.Constants
import com.example.root.moviedb.Utils.Utils
import com.example.root.moviedb.Views.Adapter.MovieAdapter
import com.example.root.moviedb.Views.Base.BaseView
import com.example.root.moviedb.databinding.ActivityHomeBinding
import io.realm.Realm
import android.text.Editable
import android.text.TextWatcher
import com.example.root.moviedb.Models.Movie
import kotlin.collections.ArrayList


/**
 * Created by Juan Arango on 3/30/18.
 */
open class MovieActivity: BaseView(), Observer{

    var movieViewModel: MovieViewModel?=null
    var activityHomebinding: ActivityHomeBinding?=null
    var realm: Realm?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)
        Realm.init(this)
        realm = Realm.getDefaultInstance()
        callService()
        initBinding()
        setListofMoview(activityHomebinding!!.rvListMovies)
        setUpObserver(movieViewModel!!)
    }

    override fun onResume() {
        super.onResume()
        if (!Utils.isNetworkAvailable(this)){
            showDialog()
            val results = realm!!.where(Movie::class.java).findAll()
            if(realm!!.copyFromRealm(results).size>0) {
                val movieAdapter= activityHomebinding!!.rvListMovies.getAdapter() as MovieAdapter
                movieAdapter.setMovieList(realm!!.copyFromRealm(results) as ArrayList<Movie>)
            }

        }else{
            callService()
        }

    }

    fun callService(){
        val querie: HashMap<String, String> = HashMap()
        querie.put(Constants.Key.API_KEY, Constants.Value.API_KEY)
        movieViewModel = MovieViewModel(this,Constants.Url.DISCOVER,querie)
    }

    fun initBinding(){
        activityHomebinding = DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)
        activityHomebinding!!.movieViewModel = movieViewModel
    }

    private fun setListofMoview(listMovies: RecyclerView) {
        listMovies.adapter = MovieAdapter()
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayout.HORIZONTAL
        listMovies.layoutManager = layoutManager

    }

    fun setUpObserver(observable: Observable) {
        observable.addObserver(this)
    }

    override fun update(observable: Observable?, arg: Any?) {
        if (observable is MovieViewModel) {
            val movieAdapter= activityHomebinding!!.rvListMovies.getAdapter() as MovieAdapter
            movieAdapter.setMovieList(observable.getMovieList())
        }
    }

    override fun onDestroy() {
        movieViewModel!!.reset()
        super.onDestroy()
    }

}
package com.example.root.moviedb.Views.Activity

import android.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.root.moviedb.Models.Movie
import com.example.root.moviedb.R
import com.example.root.moviedb.Utils.Constants
import com.example.root.moviedb.ViewModel.MovieDetailViewModel
import com.example.root.moviedb.Views.Base.BaseView
import com.example.root.moviedb.databinding.ActivityMovieDetailBinding
import io.realm.Realm


/**
 * Created by Juan Arango on 3/31/18.
 */
class MovieDetailActivity: BaseView(){

    private var movie:Movie?=null
    private var movieDetailViewModel: MovieDetailViewModel?=null
    private var activityMovieDetailBinding: ActivityMovieDetailBinding?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.getIntExtra(Constants.Key.ID,0)
        movie = Realm.getDefaultInstance().copyFromRealm(
                Realm.getDefaultInstance()
                        .where(Movie::class.java)
                        .equalTo(Constants.Key.ID, id)
                        .findFirst()!!
                )
        initBinding()
        activityMovieDetailBinding!!.toolbarMovieDetail.setTitleTextColor(Color.WHITE)
    }

    fun initBinding(){
        activityMovieDetailBinding = DataBindingUtil.setContentView<ActivityMovieDetailBinding>(this, R.layout.activity_movie_detail)
        movieDetailViewModel = MovieDetailViewModel(movie!!)
        activityMovieDetailBinding!!.movieDetailViewModel = movieDetailViewModel
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }
}

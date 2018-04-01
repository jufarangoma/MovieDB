package com.example.root.moviedb.Views.Activity

import android.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.root.moviedb.Models.Movie
import com.example.root.moviedb.R
import com.example.root.moviedb.Utils.Constants
import com.example.root.moviedb.ViewModel.MovieDetailViewModel
import com.example.root.moviedb.databinding.ActivityMovieDetailBinding


/**
 * Created by Juan Arango on 3/31/18.
 */
class MovieDetailActivity: AppCompatActivity(){

    private var movie:Movie?=null
    private var movieDetailViewModel: MovieDetailViewModel?=null
    private var activityMovieDetailBinding: ActivityMovieDetailBinding?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movie = intent.getSerializableExtra(Constants.Key.MOVIE) as Movie
        initBinding()
        activityMovieDetailBinding!!.toolbarMovieDetail.setTitleTextColor(Color.WHITE)
    }

    fun initBinding(){
        activityMovieDetailBinding = DataBindingUtil.setContentView<ActivityMovieDetailBinding>(this, R.layout.activity_movie_detail)
        movieDetailViewModel = MovieDetailViewModel(movie!!)
        activityMovieDetailBinding!!.movieDetailViewModel = movieDetailViewModel
    }
}

package com.example.root.moviedb.ViewModel

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.widget.ImageView
import com.android.databinding.library.baseAdapters.BR
import com.bumptech.glide.Glide
import com.example.root.moviedb.App.AppController
import com.example.root.moviedb.databinding.ActivityHomeBinding
import com.example.root.moviedb.Models.Movie
import com.example.root.moviedb.Utils.Constants

/**
 * Created by Juan Arango on 3/30/18.
 */
class ItemMovieViewModel(): BaseObservable(){

    private var movie: Movie?=null
    open var context: Context?=null

    constructor(movie: Movie, context: Context):this(){
        this.movie = movie
        this.context = context
    }

    //@BindingAdapter("title") fun getTitle() {movie!!.title}

    var title: String?= "" @Bindable get() { return movie!!.title!! }
    var overview: String?= "" @Bindable get() { return movie!!.overview!! }
/*
    @BindingAdapter("imageUrl")
    fun ImageView.setImageUrl(url: String) {
        Glide.with(context).load(url).into(this)
    }*/

    var photoUrl: String?= "" @Bindable get() {
        val url = Constants.Url.IMAGES + movie!!.poster_path
        return url
    }

    fun setMovie(movie: Movie){
        this.movie = movie
        notifyChange()
    }

    object ImageBindingAdapter {
        @JvmStatic
        @BindingAdapter("android:src")
        fun ImageView.setImageUrl(url: String) {
            Glide.with(context).load(url).into(this)
        }
    }
}

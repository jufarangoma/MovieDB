package com.example.root.moviedb.ViewModel

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.root.moviedb.Models.Movie
import com.example.root.moviedb.Utils.Constants
import java.util.*

/**
 * Created by Juan Arango on 3/31/18.
 */
class MovieDetailViewModel(): BaseObservable() {

    private var movie: Movie?=null

    constructor(movie: Movie):this(){
        this.movie = movie

    }

    var title: String?= "" @Bindable get() { return movie!!.title!! }
    var overview: String?= "" @Bindable get() { return movie!!.overview!! }
    var vote: String?=""@Bindable get() { return movie!!.vote_average.toString() }

    var photoUrl: String?= "" @Bindable get() {
        val url = Constants.Url.IMAGES + movie!!.poster_path
        return url
    }

    object ImageBindingAdapter {
        @JvmStatic
        @BindingAdapter("android:src")
        fun ImageView.setImageUrl(url: String) {
            Glide.with(context).load(url).into(this)
        }
    }
}
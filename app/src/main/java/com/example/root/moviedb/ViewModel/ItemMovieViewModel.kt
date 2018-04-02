package com.example.root.moviedb.ViewModel

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.view.View
import android.widget.ImageView
import com.android.databinding.library.baseAdapters.BR
import com.bumptech.glide.Glide
import com.example.root.moviedb.App.AppController
import com.example.root.moviedb.Models.Movie
import com.example.root.moviedb.R
import com.example.root.moviedb.Utils.Constants
import com.example.root.moviedb.Views.Activity.MovieDetailActivity
/*import com.vicpin.krealmextensions.queryAll
import com.vicpin.krealmextensions.queryFirst*/
import org.jetbrains.anko.startActivity

/**
 * Created by Juan Arango on 3/30/18.
 */
class ItemMovieViewModel(): BaseObservable(){

    private var movie: Movie?=null
    var context: Context?=null

    constructor(movie: Movie, context: Context):this(){
        this.movie = movie
        this.context = context
    }

    var title: String?= "" @Bindable get() { return movie!!.title!! }
    var overview: String?= "" @Bindable get() {
        if (movie!!.overview.isNullOrEmpty()) return context!!.getString(R.string.no_overview)
        return movie!!.overview!! }

    var photoUrl: String?= "" @Bindable get() {
        if(movie!!.poster_path.isNullOrEmpty()) return Constants.Url.NO_IMAGE
        val url = Constants.Url.IMAGES + movie!!.poster_path
        return url
    }

    fun onItemClick(v: View) {
        context!!.startActivity<MovieDetailActivity>(Constants.Key.ID to movie!!.id)
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

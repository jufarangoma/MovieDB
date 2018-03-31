package com.example.root.moviedb.ViewModel

import android.content.Context
import android.databinding.ObservableInt
import android.view.View
import com.example.root.moviedb.App.AppController
import com.example.root.moviedb.DataAccess.Connection.MovieService
import com.example.root.moviedb.Models.BodyResponse
import com.example.root.moviedb.Models.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Juan Arango on 3/30/18.
 */
class MovieViewModel():Observable(){

    var movies: ArrayList<Movie>?=null
    var context: Context?=null
    var compositeDisposable : CompositeDisposable?=null
    var progressBar: ObservableInt?=null
    var movieRecycler: ObservableInt?=null

    constructor(context: Context, path:String, queries: Map<String, String>):this(){
        this.context=context
        this.movies=ArrayList<Movie>()
        compositeDisposable = CompositeDisposable()
        fetchMoviesList(path,queries)
    }

    fun fetchMoviesList(path:String, queries: Map<String, String>){
        val appController = AppController.create(context!!)
        val movieService = appController.movieService!!

        val disposable = movieService.getMovies(path,queries)
                .subscribeOn(appController.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Consumer<BodyResponse> {
                    @Throws(Exception::class)
                    override fun accept(bodyResponse: BodyResponse) {
                        updateMovieList(bodyResponse.results!!)
                    }
                }, object : Consumer<Throwable> {
                    @Throws(Exception::class)
                    override fun accept(throwable: Throwable) {
                        onFailureRequest(throwable.toString())
                    }
                })
        compositeDisposable!!.add(disposable)
    }

    fun updateMovieList(arrayMovies: ArrayList<Movie>){
        movies!!.addAll(arrayMovies)
        setChanged()
        notifyObservers()
    }

    fun onFailureRequest(string: String):String{
        return string
    }

    fun getUserList(): ArrayList<Movie> {
        return movies!!
    }

    private fun unSubscribeFromObservable() {
        if (!compositeDisposable!!.isDisposed) {
            compositeDisposable!!.dispose()
        }
    }

    fun reset() {
        unSubscribeFromObservable()
        compositeDisposable = null
        context = null
    }
}
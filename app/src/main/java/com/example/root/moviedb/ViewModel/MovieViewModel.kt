package com.example.root.moviedb.ViewModel

import android.content.Context
import android.databinding.ObservableInt
import android.view.View
import com.example.root.moviedb.App.AppController
import com.example.root.moviedb.Models.BodyResponse
import com.example.root.moviedb.Models.Movie
import com.example.root.moviedb.Utils.Utils
import com.example.root.moviedb.Views.Base.BaseView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import java.util.*
import io.realm.Realm
import kotlin.collections.ArrayList

/**
 * Created by Juan Arango on 3/30/18.
 */
class MovieViewModel():Observable(){

    var movies: ArrayList<Movie>?=null
    var context: Context?=null
    var compositeDisposable : CompositeDisposable?=null
    var progressBar: ObservableInt?=null

    constructor(context: Context, path:String, queries: Map<String, String>):this(){
        this.context=context
        this.movies=ArrayList<Movie>()
        progressBar = ObservableInt(View.VISIBLE)
        compositeDisposable = CompositeDisposable()
        fetchMoviesList(path,queries)
    }

    fun fetchMoviesList(path:String, queries: Map<String, String>){
        val appController = AppController.create(context!!)
        val movieService = appController.movieService!!

        if (!Utils.isNetworkAvailable(context!!)){
            (context as BaseView).showDialog()
        }else{
            val disposable = movieService.getMovies(path,queries)
                    .subscribeOn(appController.subscribeScheduler())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object : Consumer<BodyResponse> {
                        @Throws(Exception::class)
                        override fun accept(bodyResponse: BodyResponse) {
                            val realm = Realm.getDefaultInstance()
                            realm.executeTransaction { transaction -> transaction.copyToRealmOrUpdate(bodyResponse.results!!) }
                            progressBar!!.set(View.GONE)
                            updateMovieList(realm)

                        }
                    }, object : Consumer<Throwable> {
                        @Throws(Exception::class)
                        override fun accept(throwable: Throwable) {
                            onFailureRequest(throwable.toString())
                        }
                    })
            compositeDisposable!!.add(disposable)

        }
    }

    fun updateMovieList(realm: Realm){
        val results = realm.where(Movie::class.java).findAll()
        movies!!.addAll(realm.copyFromRealm(results))
        setChanged()
        notifyObservers()
    }

    fun onFailureRequest(string: String):String{
        return string
    }

    fun getMovieList(): ArrayList<Movie> {
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
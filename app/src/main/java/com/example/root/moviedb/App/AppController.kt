package com.example.root.moviedb.App

import android.app.Application
import android.content.Context
import com.example.root.moviedb.DataAccess.Connection.ApiFactory
import com.example.root.moviedb.DataAccess.Connection.MovieService
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

/**
 * Created by Juan Arango on 3/30/18.
 */
class AppController : Application() {

    var movieService: MovieService? = null
        get() {
            if (field == null) {
                movieService = ApiFactory.create()
            }
            return field
        }
    private var scheduler: Scheduler? = null

    fun subscribeScheduler(): Scheduler? {
        if (scheduler == null) {
            scheduler = Schedulers.io()
        }
        return scheduler
    }

    fun setScheduler(scheduler: Scheduler) {
        this.scheduler = scheduler
    }

    companion object {

        private operator fun get(context: Context): AppController {
            return context.getApplicationContext() as AppController
        }

        fun create(context: Context): AppController {
            return AppController[context]
        }
    }

}
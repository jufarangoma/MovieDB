package com.example.root.moviedb.Views.Activity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.example.root.moviedb.ViewModel.MovieViewModel
import java.util.*

/**
 * Created by Juan Arango on 3/30/18.
 */
class MovieActivity: AppCompatActivity(), Observer{

    override fun update(p0: Observable?, p1: Any?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var movieViewModel: MovieViewModel?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val querie: HashMap<String, String> = HashMap()

        querie.put("api_key", "34b7e528efc37e20e1af4684bee2a868")
        movieViewModel = MovieViewModel(this,"discover/movie",querie)

    }

}
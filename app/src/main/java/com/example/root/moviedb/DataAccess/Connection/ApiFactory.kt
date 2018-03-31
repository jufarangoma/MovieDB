package com.example.root.moviedb.DataAccess.Connection

import com.example.root.moviedb.Utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


/**
 * Created by Juan Arango on 3/30/18.
 */
object ApiFactory {

    fun create(): MovieService {
        val retrofit = Retrofit.Builder().baseUrl(Constants.Url.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return retrofit.create(MovieService::class.java)
    }

}
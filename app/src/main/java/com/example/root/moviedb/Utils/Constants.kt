package com.example.root.moviedb.Utils

/**
 * Created by Juan Arango on 3/30/18.

 */
object Constants{
    object Url{
        val BASE_URL = "https://api.themoviedb.org/3/"
        val DISCOVER = "discover/movie"
        val IMAGES = "https://image.tmdb.org/t/p/w500/"
        val SEARCH = "search/movie"
        val NO_IMAGE= "http://www.maclaren.es/c.3517976/b2c/img/no_image_available.jpeg"
    }

    object Value{
        val API_KEY = "34b7e528efc37e20e1af4684bee2a868"
        val NOINTERNET = "no internet"
    }

    object Key{
        val API_KEY = "api_key"
        val MOVIE= "Movie"
        val Action = "action"
        val ID = "id"
        val QUERIE = "query"
    }
}
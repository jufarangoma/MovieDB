package com.example.root.moviedb.DataAccess.Connection

/**
 * Created by Juan Arango on 3/30/18.
 */
import com.example.root.moviedb.Models.BodyResponse
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap
import retrofit2.http.Url;

interface MovieService {
    @GET
    open fun getMovies(@Url path:String,@QueryMap query: Map<String,String>): Observable<BodyResponse>
}
package com.example.root.moviedb.Models

import java.util.ArrayList
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
* Created by Juan Arango on 3/30/18.
*/

class BodyResponse{
    @SerializedName("page")
    @Expose
    val page: Int?=null
    @SerializedName("results")
    @Expose
    val results: ArrayList<Movie>?=null
}
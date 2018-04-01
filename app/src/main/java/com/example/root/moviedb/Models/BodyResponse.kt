package com.example.root.moviedb.Models

import java.util.ArrayList
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject

/**
* Created by Juan Arango on 3/30/18.
*/

class BodyResponse{
    @SerializedName("page")
    @Expose
    var page: Int?=null
    @SerializedName("results")
    @Expose
    var results: RealmList<Movie>?=null
}
package com.example.root.moviedb.Models

import android.databinding.DataBindingUtil
import io.realm.RealmObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
* Created by Juan Arango on 3/29/18.
*/

class Movie: RealmObject() {

    @SerializedName("id")
    @Expose
    val id: Int?=null
    @SerializedName("vote_average")
    @Expose
    val vote_average: Double?=null
    @SerializedName("title")
    @Expose
    val title: String?=null
    @SerializedName("poster_path")
    @Expose
    val poster_path:String?=null
    @SerializedName("overview")
    @Expose
    val overview: String?=null
    @SerializedName("backdrop_path")
    @Expose
    val backdrop_path:String?=null
    @SerializedName("release_date")
    @Expose
    val release_date:String?=null
}

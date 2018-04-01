package com.example.root.moviedb.Models

import android.databinding.DataBindingUtil
import io.realm.RealmObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.annotations.PrimaryKey
import java.io.Serializable

/**
* Created by Juan Arango on 3/29/18.
*/

open class Movie: RealmObject(), Serializable {

    @SerializedName("id")
    @Expose
    @PrimaryKey var id: Int?=null
    @SerializedName("vote_average")
    @Expose
    var vote_average: Double?=null
    @SerializedName("title")
    @Expose
    var title: String?=null
    @SerializedName("poster_path")
    @Expose
    var poster_path:String?=null
    @SerializedName("overview")
    @Expose
    var overview: String?=null
    @SerializedName("backdrop_path")
    @Expose
    var backdrop_path:String?=null
    @SerializedName("release_date")
    @Expose
    var release_date:String?=null
}

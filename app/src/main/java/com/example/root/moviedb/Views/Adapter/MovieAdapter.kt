package com.example.root.moviedb.Views.Adapter

import android.databinding.DataBindingUtil.inflate
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.root.moviedb.Models.Movie
import com.example.root.moviedb.R
import com.example.root.moviedb.ViewModel.ItemMovieViewModel
import com.example.root.moviedb.databinding.CardMovieBinding
import kotlinx.android.synthetic.main.card_movie.view.*

/**
 * Created by Juan Arango on 3/30/18.
 */
class MovieAdapter(): RecyclerView.Adapter<MovieAdapter.MovieAdapterViewHolder>() {

    var movies = ArrayList<Movie>()

    override fun getItemCount(): Int = movies.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MovieAdapterViewHolder {
        val cardMovieBinding: CardMovieBinding = inflate(LayoutInflater.from(parent!!.getContext()),
                R.layout.card_movie, parent, false)
        return MovieAdapterViewHolder(cardMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieAdapterViewHolder?, position: Int) {
        holder!!.setMovie(movies.get(position))
    }

    fun setMovieList(movieList: ArrayList<Movie>) {
        this.movies = movieList
        notifyDataSetChanged()
    }

    class MovieAdapterViewHolder(internal var cardMovieBinding: CardMovieBinding) : RecyclerView.ViewHolder(cardMovieBinding.cvMovie){

        init {
            super.itemView.cv_movie
        }

        fun setMovie(movie: Movie){
            if (cardMovieBinding.itemViewModel == null) {
                cardMovieBinding.itemViewModel = ItemMovieViewModel()
            } else {
                //cardMovieBinding.itemViewModel.setMovie(movie)
            }
        }
    }

}
package com.example.recyclerimageapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.recyclerimageapp.databinding.ItemMovieBinding

class MovieAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.tvMovieTitle.text = movie.name
        Glide.with(holder.itemView.context)
            .load(movie.imageUrl)
            .apply(RequestOptions().transform(RoundedCorners(16)))
            .into(holder.binding.imgMovie)

        //when user clicks on the movie title
        holder.binding.tvMovieTitle.setOnClickListener {
            Toast.makeText(holder.itemView.context, "${movie.name}", Toast.LENGTH_SHORT).show()
        }

        //when user clicks on the movie image
        holder.binding.imgMovie.setOnClickListener {
            Toast.makeText(holder.itemView.context, "${movie.name}", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return movies.size
    }
}

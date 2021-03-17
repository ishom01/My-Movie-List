package id.ishom.movielist.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ishom.movielist.R
import id.ishom.movielist.activity.MovieDetailActivity
import id.ishom.movielist.core.getUrl
import id.ishom.movielist.core.toDisplayString
import id.ishom.movielist.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(val context: Context, var movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        lateinit var movie: Movie
        val itemLayout = view.itemLayout
        val nameTextView = view.nameTextView
        val dateTextView = view.dateTextView
        val descriptionTextView = view.descriptionTextView
        val imageView = view.imageView

        init {
            itemLayout.setOnClickListener {
                val intent = Intent(context, MovieDetailActivity::class.java)
                intent.putExtra("movie", movie)
                context.startActivity(intent)
            }
        }
    }

    fun updateData(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.movie = movie
        holder.nameTextView.text = movie.title
        holder.dateTextView.text = movie.release_date.toDisplayString()
        holder.descriptionTextView.text = movie.overview
        holder.imageView.setImageURI(movie.poster_path.getUrl())
    }

    override fun getItemCount(): Int {
        return movies.size
    }

}
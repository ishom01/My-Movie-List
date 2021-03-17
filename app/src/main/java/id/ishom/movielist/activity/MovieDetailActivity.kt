package id.ishom.movielist.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ishom.movielist.R
import id.ishom.movielist.core.getUrl
import id.ishom.movielist.core.toDisplayString
import id.ishom.movielist.model.Movie
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val movie = intent.getSerializableExtra("movie") as Movie
        nameTextView.text = movie.title
        dateTextView.text = movie.release_date.toDisplayString()
        descriptionTextView.text = movie.overview
        imageView.setImageURI(movie.poster_path.getUrl())
    }
}
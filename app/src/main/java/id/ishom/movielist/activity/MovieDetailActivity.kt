package id.ishom.movielist.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import id.ishom.movielist.R
import id.ishom.movielist.core.getUrl
import id.ishom.movielist.core.setFavoriteIcon
import id.ishom.movielist.core.toDisplayString
import id.ishom.movielist.model.FavoriteMovie
import id.ishom.movielist.model.Movie
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.activity_movie_detail.toolbar

class MovieDetailActivity : AppCompatActivity() {

    var isFavorite: Boolean = false
    lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        movie = intent.getSerializableExtra("movie") as Movie
        isFavorite = movie.id == FavoriteMovie.get(movie)?.id
        favoriteImageView.setFavoriteIcon(isFavorite)

        nameTextView.text = movie.title
        dateTextView.text = movie.release_date.toDisplayString()
        descriptionTextView.text = movie.overview
        imageView.setImageURI(movie.poster_path.getUrl())

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun onFavoriteClicked(view: View) {
        isFavorite = !isFavorite
        favoriteImageView.setFavoriteIcon(isFavorite)
        if (isFavorite) {
            Toast.makeText(this, "${movie.title} added in favorite list", Toast.LENGTH_SHORT).show()
            FavoriteMovie.add(movie)
        } else {
            Toast.makeText(this, "${movie.title} removed in favorite list", Toast.LENGTH_SHORT).show()
            FavoriteMovie.delete(movie)
        }
    }
}
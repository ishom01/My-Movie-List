package id.ishom.movielist.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ishom.movielist.R
import id.ishom.movielist.adapter.FavoriteMovieAdapter
import id.ishom.movielist.model.FavoriteMovie
import id.ishom.movielist.model.Movie
import kotlinx.android.synthetic.main.activity_main.*

class FavoriteMovieActivity : AppCompatActivity() {
    lateinit var adapter: FavoriteMovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_movie)

        adapter = FavoriteMovieAdapter(this, listOf())
        recyclerView.apply {
            adapter = this@FavoriteMovieActivity.adapter
        }

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onResume() {
        super.onResume()
        adapter.updateData(FavoriteMovie.all())
    }
}
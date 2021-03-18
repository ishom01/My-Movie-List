package id.ishom.movielist.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import id.ishom.movielist.R
import id.ishom.movielist.adapter.MovieAdapter
import id.ishom.movielist.dialog.AlertDialog
import id.ishom.movielist.model.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MovieIndexActivity : AppCompatActivity(), MoviePresenter.View {

    lateinit var adapter: MovieAdapter
    lateinit var presenter: MoviePresenter

    var displayedMovies = arrayListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MoviePresenter(this)
        adapter = MovieAdapter(this, displayedMovies)
        recyclerView.apply {
            adapter = this@MovieIndexActivity.adapter
        }
        setSupportActionBar(toolbar)

        presenter.getPopular()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_favorite, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_favorite -> {
                startActivity(Intent(this, FavoriteMovieActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun onCategoryClicked(view: View) {

    }

    override fun onSuccessFullGetMovies(movies: List<Movie>) {
        adapter.updateData(movies)
    }

    override fun onFailedGetMovies(message: String) {
        AlertDialog.createDialog(this, message)
    }
}
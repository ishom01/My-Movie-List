package id.ishom.movielist.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
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
            layoutManager = LinearLayoutManager(this@MovieIndexActivity)
        }
        presenter.getPopular()
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
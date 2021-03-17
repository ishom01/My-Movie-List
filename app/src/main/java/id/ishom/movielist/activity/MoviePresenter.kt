package id.ishom.movielist.activity

import id.ishom.movielist.core.ApiClient
import id.ishom.movielist.core.ErrorUtils
import id.ishom.movielist.model.Movie
import id.ishom.movielist.model.PopularMovies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviePresenter(val view: View) {

    interface View {
        fun onSuccessFullGetMovies(movies: List<Movie>)
        fun onFailedGetMovies(message: String)
    }

    fun getPopular() {
        ApiClient.movieApi().getPopularMovies(ApiClient.API_KEY).enqueue(object: Callback<PopularMovies> {
            override fun onResponse(call: Call<PopularMovies>, response: Response<PopularMovies>) {
                if (response.isSuccessful) {
                    view.onSuccessFullGetMovies(response.body()!!.results)
                } else {
                    view.onFailedGetMovies(ErrorUtils.parseError(response).status_message)
                }
            }
            override fun onFailure(call: Call<PopularMovies>, t: Throwable) {
                view.onFailedGetMovies(t.message.toString())
            }
        })
    }
}
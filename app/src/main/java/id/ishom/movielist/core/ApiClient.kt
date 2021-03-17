package id.ishom.movielist.core

import id.ishom.movielist.model.PopularMovies
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object ApiClient {

    private const val BASE_URL = "https://api.themoviedb.org/3/"
    const val IMAGE_URL = "https://image.tmdb.org/t/p/w500/"
    const val API_KEY = "f53b614e0010321fbcfec89277cbd5fb"

    val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun movieApi(): MovieApiInterface {
        return retrofit.create(MovieApiInterface::class.java)
    }
}

interface MovieApiInterface {

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") key: String) : Call<PopularMovies>
}
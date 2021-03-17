package id.ishom.movielist.model

data class PopularMovies(
    val page: Int,
    val results: List<Movie>,
)
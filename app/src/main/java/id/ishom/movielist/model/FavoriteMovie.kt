package id.ishom.movielist.model

import android.util.Log
import io.realm.Realm
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class FavoriteMovie: RealmObject() {
    @PrimaryKey
    var id: Int = 0
    lateinit var title: String
    var overview: String = ""
    var poster_path: String = ""
    var release_date: String = ""

    companion object {
        fun all(): List<FavoriteMovie> {
            return Realm.getDefaultInstance().where(FavoriteMovie::class.java).findAll()
        }

        fun add(movie: Movie) {
            val favoriteMovie = FavoriteMovie()
            favoriteMovie.id = movie.id
            favoriteMovie.title = movie.title
            favoriteMovie.overview = movie.overview
            favoriteMovie.release_date = movie.release_date
            favoriteMovie.poster_path = movie.poster_path

            Realm.getDefaultInstance().executeTransaction {
                it.copyToRealmOrUpdate(favoriteMovie)
            }
        }

        fun get(movie: Movie): FavoriteMovie? {
            Log.e("Status ID", movie.id.toString())
            return Realm.getDefaultInstance().where(FavoriteMovie::class.java).equalTo("id", movie.id).findFirst()
        }

        fun delete(movie: Movie) {
            Realm.getDefaultInstance().executeTransaction {
                get(movie)?.deleteFromRealm()
            }
        }
    }

    fun parse(): Movie {
        return Movie(id, overview, poster_path, release_date, title)
    }
}
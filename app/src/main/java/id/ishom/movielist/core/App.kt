package id.ishom.movielist.core

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import io.realm.Realm
import io.realm.RealmConfiguration

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)

        Realm.init(this)
        val realmConfig = RealmConfiguration.Builder()
            .name("MovieList.db")
            .schemaVersion(1)
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.getInstance(realmConfig)
    }
}
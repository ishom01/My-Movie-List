package id.ishom.movielist.core

import android.widget.ImageView
import id.ishom.movielist.R
import java.text.SimpleDateFormat

fun String.getUrl(): String {
    return "${ApiClient.IMAGE_URL}$this"
}

fun String.toDisplayString(): String {
    return SimpleDateFormat("EEEE, dd MMM yyyy").format(SimpleDateFormat("yyyy-MM-dd").parse(this))
}

fun ImageView.setFavoriteIcon(isFavorite: Boolean) {
    if (isFavorite) {
        this.setImageDrawable(resources.getDrawable(R.drawable.ic_selected_favorite))
    } else {
        this.setImageDrawable(resources.getDrawable(R.drawable.ic_unselected_favorite))
    }
}
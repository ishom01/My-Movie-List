package id.ishom.movielist.core

import java.text.SimpleDateFormat

fun String.getUrl(): String {
    return "${ApiClient.IMAGE_URL}$this"
}

fun String.toDisplayString(): String {
    return SimpleDateFormat("EEEE, dd MMM yyyy").format(SimpleDateFormat("yyyy-MM-dd").parse(this))
}
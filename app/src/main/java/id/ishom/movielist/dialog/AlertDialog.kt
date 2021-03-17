package id.ishom.movielist.dialog

import android.content.Context
import androidx.appcompat.app.AlertDialog

object AlertDialog {

    fun createDialog(context: Context, message: String) {
        val builder = AlertDialog.Builder(context)
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.cancel()
        }
        builder.show()
    }
}
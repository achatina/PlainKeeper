package nikita.com.plainkeeper.base

import android.app.AlertDialog
import android.support.annotation.StringRes
import nikita.com.plainkeeper.R

interface AlertView : BaseView {

    fun showAlert(title: String, message: String) {
        AlertDialog.Builder(viewContext())
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(viewContext()?.getString(R.string.alert_dialog_positive_button) ?: "OK") { dialog, _ -> dialog.dismiss() }
            .show()
    }

    fun showAlert(@StringRes title: Int, message: String) {
        showAlert(title = viewContext()?.getString(title) ?: "Error", message = message)
    }

    fun showAlert(@StringRes title: Int, @StringRes message: Int) {
        showAlert(title = viewContext()?.getString(title) ?: "Error",
            message = viewContext()?.getString(message) ?: "Error")
    }

    fun showAlert(title: String, @StringRes message: Int) {
        showAlert(title, message = viewContext()?.getString(message) ?: "Error")
    }

}
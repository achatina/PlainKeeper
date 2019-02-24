package nikita.com.plainkeeper.base

import android.view.View
import android.view.WindowManager

interface ProgressView : BaseView {

    fun showProgress(blockUI: Boolean = true) {
        progressView()?.visibility = View.VISIBLE

        if (blockUI) {
            viewContext()?.window?.setFlags(
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        }
    }

    fun closeProgress() {
        progressView()?.visibility = View.GONE
        viewContext()?.window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }

    fun progressView() : View?

}
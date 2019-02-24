package nikita.com.plainkeeper.auth

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import nikita.com.plainkeeper.R

class AuthActivity : AppCompatActivity(), AuthView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
    }

    override fun loginComplete() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerComplete() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun email(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun password(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun userName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun viewContext(): Activity? = this

    override fun progressView(): View? = null
}

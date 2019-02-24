package nikita.com.plainkeeper.auth

import nikita.com.plainkeeper.base.BasePresenter
import nikita.com.plainkeeper.base.BaseView
import nikita.com.plainkeeper.base.ProgressView

interface AuthView : BaseView, ProgressView {

    fun loginComplete()

    fun registerComplete()

    fun email(): String

    fun password(): String

    fun userName(): String

}

interface AuthPresenter : BasePresenter<AuthView> {

    fun login()

    fun register()

}
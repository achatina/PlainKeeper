package nikita.com.plainkeeper.auth

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class AuthPresenterImpl() : AuthPresenter {

    override var view: AuthView? = null
    private var authJob: Job? = null


    override fun detachView() {
        super.detachView()
        authJob?.cancel()

    }
    override fun login() {
        authJob = GlobalScope.launch(Dispatchers.Main) {
            view?.showProgress()
        }
    }

    override fun register() {
        authJob = GlobalScope.launch(Dispatchers.Main) {
            view?.showProgress()
        }
    }

}
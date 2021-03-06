package nikita.com.plainkeeper.base

interface BasePresenter<T : BaseView> {

    var view: T?

    fun attachView(view: T) {
        this.view = view
    }

    fun detachView() {
        view = null
    }

}
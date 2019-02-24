package nikita.com.plainkeeper.session

interface SessionRepository {

    fun saveToken(token: String)

    fun token(): String

    fun clearToken()

}
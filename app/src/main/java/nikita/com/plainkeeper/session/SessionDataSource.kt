package nikita.com.plainkeeper.session

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class SessionDataSource(private val context: Context) : SessionRepository {

    companion object {
        private const val TOKEN = "plain_keeper_token"
        private const val SESSION_PREFS = "session_prefs"
    }

    private fun prefs(): SharedPreferences = context.getSharedPreferences(SESSION_PREFS, MODE_PRIVATE)

    override fun saveToken(token: String) {
        prefs().edit().putString(TOKEN, token).apply()
    }

    override fun token() = prefs().getString(TOKEN, "") ?: ""

    override fun clearToken() {
        prefs().edit().clear().apply()
    }
}
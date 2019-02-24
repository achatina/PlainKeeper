package nikita.com.plainkeeper.auth

import nikita.com.plainkeeper.session.SessionRepository

class AuthDataSource(private val sessionRepository: SessionRepository) : AuthRepository {
}
package nikita.com.plainkeeper.network.models

data class User(
    val id: Int,
    val email: String,
    val username: String,
    val token: String?,
    val wallets: List<Wallet>
)

data class Registration(
    val email: String,
    val password: String,
    val username: String
)

data class Recovery(
    val email: String,
    val old_password: String,
    val new_password: String
)

data class LoginResponse(
    val token: String
)
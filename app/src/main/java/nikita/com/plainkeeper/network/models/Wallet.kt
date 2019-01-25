package nikita.com.plainkeeper.network.models

data class Wallet(
    val id: Int,
    val owner_id: Int,
    val profit: Double,
    val title: String,
    val incomes: List<Transaction>?,
    val outcomes: List<Transaction>?
)

data class Transaction(
    val id: Int,
    val wallet_id: Int,
    val owner_id: Int,
    val value: Double,
    val title: String,
    val category: String
)
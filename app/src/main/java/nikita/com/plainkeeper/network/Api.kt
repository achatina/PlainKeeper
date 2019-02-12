package nikita.com.plainkeeper.network

import nikita.com.plainkeeper.network.models.*
import retrofit2.Call
import retrofit2.http.*

interface Api {

    @POST("login")
    fun login(@Header("Authorization") basic: String): Call<NetworkResponse<LoginResponse>>

    @POST("register")
    fun register(@Body body: Registration): Call<NetworkResponse<User>>

    @POST("recovery")
    fun recovery(@Body body: Recovery): Call<NetworkResponse<Any?>>

    @GET("user")
    fun user(@Header("Authorization") basic: String): Call<NetworkResponse<User>>

    @GET("wallet/{walletId}")
    fun wallet(
        @Header("Authorization") basic: String,
        @Path("walletId") walletId: Int
    ): Call<NetworkResponse<Wallet>>

    @PATCH("wallet/{walletId}")
    fun updateWallet(
        @Header("Authorization") basic: String,
        @Path("walletId") walletId: Int,
        @Body body: UpdateWallet
    ): Call<NetworkResponse<Wallet>>

    @POST("wallet/{walletId}/transaction")
    fun addTransaction(
        @Header("Authorization") basic: String,
        @Path("walletId") walletId: Int,
        @Body body: Transaction
    ): Call<NetworkResponse<Transaction>>


    @DELETE("wallet/{walletId}/transaction")
    fun deleteTransaction(
        @Header("Authorization") basic: String,
        @Path("walletId") walletId: Int,
        @Body body: Transaction
    ): Call<NetworkResponse<Any?>>


    @PATCH("wallet/{walletId}/transaction")
    fun updateTransaction(
        @Header("Authorization") basic: String,
        @Path("walletId") walletId: Int,
        @Body body: Transaction
    ): Call<NetworkResponse<Transaction>>
}
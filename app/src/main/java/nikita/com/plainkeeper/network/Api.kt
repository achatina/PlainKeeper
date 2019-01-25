package nikita.com.plainkeeper.network

import nikita.com.plainkeeper.network.models.LoginResponse
import retrofit2.Call
import retrofit2.http.Header
import retrofit2.http.POST

interface Api {

    @POST("login")
    fun login(@Header("Authorization") basic: String): Call<NetworkResponse<LoginResponse>>

}
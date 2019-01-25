package nikita.com.plainkeeper.network

import com.google.gson.annotations.SerializedName

data class NetworkResponse<T>(
    val result: T?,
    val error: Error?
)

data class Error(val code: Int,
                 @SerializedName("error")
                 val message: String)
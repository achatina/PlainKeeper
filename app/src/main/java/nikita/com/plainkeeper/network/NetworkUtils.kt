package nikita.com.plainkeeper.network

import okhttp3.ResponseBody

const val CODE_SUCESS = 200
const val ERROR_400 = 400
const val ERROR_401 = 401

fun getHttpErrorMessage(e: ResponseBody): String {
    var error = e.string()
    if (error.contains("messages")) {
        error = error.replace("\"", "")
        error = error.substring(error.indexOf("[") + 1)
        error = error.substring(0, error.lastIndexOf("]"))
    }
    return error
}

fun isUnauthorized(code: Int? = null, error: String? = ""): Boolean {
    return code == ERROR_401 || error == "Unauthenticated."
}
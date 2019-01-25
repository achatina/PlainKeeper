package nikita.com.plainkeeper.network

import android.util.Log
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import java.io.IOException

class ResponseInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {

        val original = chain.request()
        val request = chain.request().newBuilder()
            .header("Content-Type", "application/json")
            .method(original.method(), original.body())
            .build()

        var response = chain.proceed(request)
        val body = response.peekBody(java.lang.Long.MAX_VALUE)

        if (response.isSuccessful && body.contentType()?.subtype() == "json") {
            val json = body.string()
            val jsonBody = JsonParser().parse(json).asJsonObject
            makeSureThereNoError(jsonBody)
            if (jsonBody.has("body")) {
                response = changeResponse(response, jsonBody)
            }
        } else {
            val error = getHttpErrorMessage(body)
            throw Exception(error)
        }

        return response
    }

    private fun makeSureThereNoError(jsonBody: JsonObject) {
        val responseStatus = jsonBody.get("status")

        if (responseStatus.asInt != CODE_SUCESS) {
            val errorMessage = jsonBody.get("messages").asString
            throw IllegalStateException(
                errorMessage + " status = " + responseStatus.asInt)
        }
    }

    private fun changeResponse(response: Response, sourceJsonBody: JsonObject): Response {
        val contentType = response.body()?.contentType()
        val newBody = ResponseBody.create(contentType, sourceJsonBody.get("body").toString())
        return response.newBuilder().body(newBody).build()
    }

}

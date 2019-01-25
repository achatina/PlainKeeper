package nikita.com.plainkeeper.network

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    fun retrofitClient(gson: Gson): Retrofit {

        return Retrofit.Builder()
            .baseUrl("https://coin-keeper-rest.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(OkHttpClient.Builder().addInterceptor(ResponseInterceptor()).build())
            .build()
    }

}
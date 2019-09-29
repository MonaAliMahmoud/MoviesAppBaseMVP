package com.mona.basemvp.base

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource {
    companion object {
        val instance = RemoteDataSource()

        private const val URL = "https://api.themoviedb.org/3/"
        private const val Api_Key = "api_key"
        private const val Api_Key_Value = "bd9eb9f62e484b7b3de4718afb6cd421"

    }

    private val okHttpClient: OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor { chain ->
                val request = chain.request()
                val url = request.url()
                val newUrl= url.newBuilder().addQueryParameter(Api_Key, Api_Key_Value)
                    .build()

                val builder = request.newBuilder()
                builder.url(newUrl)

                chain.proceed(builder.build())
            }
            .build()

//    Retrofit
     var retrofit: Retrofit? =
        retrofit2.Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

}
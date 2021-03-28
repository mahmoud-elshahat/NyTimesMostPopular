package com.mahmoudelshahat.nytimesmp.data.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.mahmoudelshahat.nytimesmp.data.response.NyTimesResponse
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//http://api.nytimes.com/svc/mostpopular/v2/viewed/7.json?api-key=0X6tlGMQKSJJF3zjePYz5SvVaMO3I64p



const val API_KEY = "0X6tlGMQKSJJF3zjePYz5SvVaMO3I64p"


interface NyTimesApiService {

    @GET( "v2/viewed/7.json")
    fun getNyTimesMostPopular(): Deferred<NyTimesResponse>


    companion object{
        operator fun invoke():NyTimesApiService{
            val requestInterceptor = Interceptor{ chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("api-key", API_KEY)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.nytimes.com/svc/mostpopular/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NyTimesApiService::class.java)
        }
    }

}
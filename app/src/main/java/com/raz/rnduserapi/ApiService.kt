package com.raz.rnduserapi

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL="https://randomuser.me/"
private val moshi=Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit=Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(
    BASE_URL).build()

interface ApiService {
    @GET("api")
    fun getAdatok(@Query("results") results:Int): Call<UserResults>
}

object UserDataApi {
    val retrofitService:ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
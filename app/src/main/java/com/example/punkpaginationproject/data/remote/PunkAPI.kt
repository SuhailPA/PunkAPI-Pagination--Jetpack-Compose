package com.example.punkpaginationproject.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface PunkAPI {

    @GET("beers")
    suspend fun getAllBears(
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): List<RemoteDataItem>

}
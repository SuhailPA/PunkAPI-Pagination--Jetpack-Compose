package com.example.punkpaginationproject.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.example.punkpaginationproject.data.local.PunkDatabase
import com.example.punkpaginationproject.data.local.PunkRoomDataItem
import com.example.punkpaginationproject.data.remote.PunkAPI
import com.example.punkpaginationproject.data.repository.PunkRemoteMediator
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface PunkContainerImpl {
    val pager: Pager<Int, PunkRoomDataItem>
}

class PunkContainer(context: Context) : PunkContainerImpl {

    val baseURL = "https://api.punkapi.com/v2/"
    val json = Json { ignoreUnknownKeys = true }
    val roomDb: PunkDatabase = Room.databaseBuilder(
        context = context,
        klass = PunkDatabase::class.java,
        name = "punk_database"
    ).build()

    val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseURL)
        .build()

    val punkAPI: PunkAPI = retrofit.create(PunkAPI::class.java)

    @OptIn(ExperimentalPagingApi::class)
    override val pager: Pager<Int, PunkRoomDataItem> by lazy {
        Pager(
            config = PagingConfig(pageSize = 30),
            remoteMediator = PunkRemoteMediator(roomDb = roomDb, punkAPI = punkAPI),
            pagingSourceFactory = {
                roomDb.punkDao().getAllData()
            }
        )
    }

}
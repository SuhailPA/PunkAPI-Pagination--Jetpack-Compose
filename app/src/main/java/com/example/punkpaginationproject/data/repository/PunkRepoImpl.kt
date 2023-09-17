package com.example.punkpaginationproject.data.repository

import androidx.paging.PagingSource
import com.example.punkpaginationproject.data.local.model.PunkRoomDataItem
import com.example.punkpaginationproject.data.remote.RemoteDataItem

interface PunkRepoImpl {
    suspend fun getAllItems(): List<RemoteDataItem>

    fun getAllDbItems(): PagingSource<Int, PunkRoomDataItem>

    fun clearDB()
}
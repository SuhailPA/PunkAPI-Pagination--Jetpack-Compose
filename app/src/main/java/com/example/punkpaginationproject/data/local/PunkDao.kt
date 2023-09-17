package com.example.punkpaginationproject.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import com.example.punkpaginationproject.data.local.model.PunkRoomDataItem


@Dao
interface PunkDao {

    @Query("SELECT * FROM punkroomdataitem")
    fun getAllData(): PagingSource<Int, PunkRoomDataItem>

    @Query("DELETE FROM punkroomdataitem")
    suspend fun clearDB()
}
package com.example.punkpaginationproject.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface PunkDao {

    @Query("SELECT * FROM punkroomdataitem")
    fun getAllData(): PagingSource<Int, PunkRoomDataItem>

    @Query("DELETE FROM punkroomdataitem")
    suspend fun clearDB()

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertPunkItems(list: List<PunkRoomDataItem>)
}
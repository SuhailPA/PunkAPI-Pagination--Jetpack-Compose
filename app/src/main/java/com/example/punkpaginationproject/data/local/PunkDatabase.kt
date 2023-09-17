package com.example.punkpaginationproject.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PunkRoomDataItem::class], version = 1)
abstract class PunkDatabase : RoomDatabase() {
    abstract fun punkDao(): PunkDao
}
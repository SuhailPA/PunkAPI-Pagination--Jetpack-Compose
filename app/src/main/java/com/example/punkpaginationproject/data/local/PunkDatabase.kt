package com.example.punkpaginationproject.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.punkpaginationproject.data.local.model.PunkRoomDataItem

@Database(entities = [PunkRoomDataItem::class], version = 1)
abstract class PunkDatabase : RoomDatabase()
package com.example.punkpaginationproject.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.punkpaginationproject.data.remote.RemoteDataItem

@Entity
data class PunkRoomDataItem(
    val brewersTips: String,
    val description: String,
    val firstBrewed: String,
    @PrimaryKey
    val id: Int,
    val imageUrl: String,
    val name: String,
    val tagline: String
)

fun PunkRoomDataItem.toRemoteDataItem(): RemoteDataItem {
    return RemoteDataItem(
        brewers_tips = brewersTips,
        description = description,
        first_brewed = firstBrewed,
        id = id,
        image_url = imageUrl,
        name = name,
        tagline = tagline
    )
}
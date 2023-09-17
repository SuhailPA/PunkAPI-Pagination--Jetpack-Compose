package com.example.punkpaginationproject.data.remote

import com.example.punkpaginationproject.data.local.PunkRoomDataItem
import kotlinx.serialization.Serializable

@Serializable
data class RemoteDataItem(
    val brewers_tips: String,
    val description: String,
    val first_brewed: String,
    val id: Int,
    val image_url: String,
    val name: String,
    val tagline: String
)

fun RemoteDataItem.toPunkRoomDataItem(): PunkRoomDataItem {
    return PunkRoomDataItem(
        brewersTips = brewers_tips,
        description = description,
        firstBrewed = first_brewed,
        id = id,
        imageUrl = image_url,
        name = name,
        tagline = tagline
    )
}

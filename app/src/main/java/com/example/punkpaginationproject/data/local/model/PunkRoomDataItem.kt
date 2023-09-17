package com.example.punkpaginationproject.data.local.model

import androidx.room.Entity

@Entity
data class PunkRoomDataItem(
    val brewers_tips: String,
    val description: String,
    val first_brewed: String,
    val id: Int,
    val image_url: String,
    val name: String,
    val tagline: String
)
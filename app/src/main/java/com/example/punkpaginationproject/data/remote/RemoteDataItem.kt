package com.example.punkpaginationproject.data.remote

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

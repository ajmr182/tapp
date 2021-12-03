package com.example.tprueba.ui.models

import com.google.gson.annotations.SerializedName

data class FeedResponse (
    @SerializedName("id") val id:Int,
    @SerializedName("title") val title:String,
    @SerializedName("image") val image:String,
    @SerializedName("description") val description:String,
    @SerializedName("published") val published:String,
    @SerializedName("author_id") val author_id: String
        )
package com.example.tprueba.ui.services

import com.example.tprueba.ui.models.FeedResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET ("api/feed")
    fun getFeed(): Call<List<FeedResponse>>
}
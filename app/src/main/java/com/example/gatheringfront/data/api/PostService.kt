package com.example.gatheringfront.data.api

import com.example.gatheringfront.data.model.PostDto
import retrofit2.http.GET

interface PostService {

    @GET("/posts")
    suspend fun getMemberList(

    ): PostDto

}
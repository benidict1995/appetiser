package com.benidict.data.service

import com.benidict.domain.model.DataResponse
import com.benidict.domain.model.MediaData
import retrofit2.http.GET

interface RemoteService {
    @GET("search?term=star&amp;country=au&amp;media=movie&amp;all")
    suspend fun loadMediaList(): DataResponse<List<MediaData>>
}
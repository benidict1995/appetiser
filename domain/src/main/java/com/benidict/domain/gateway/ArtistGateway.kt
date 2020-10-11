package com.benidict.domain.gateway

import com.benidict.domain.model.MediaData

interface ArtistGateway{
    suspend fun loadArtistList(): List<MediaData>
    suspend fun loadArtistListLocal(): List<MediaData>
    suspend fun saveArtistListLocal(list: List<MediaData>): List<MediaData>
    suspend fun clearArtistListLocal()

    suspend fun saveArtistDetails(mediaData: MediaData)
    suspend fun loadArtistDetails(): MediaData?
    suspend fun removeArtistDetails()
}
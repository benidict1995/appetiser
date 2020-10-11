package com.benidict.domain.interactor

import com.benidict.domain.gateway.ArtistGateway
import com.benidict.domain.model.MediaData

class SaveArtistDetailsUseCase(private val artistGateway: ArtistGateway){
    suspend fun invoke(mediaData: MediaData) = artistGateway.saveArtistDetails(mediaData)
}
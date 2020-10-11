package com.benidict.domain.interactor

import com.benidict.domain.gateway.ArtistGateway

class ClearArtistDetailsUseCase (private val artistGateway: ArtistGateway){
    suspend fun invoke() = artistGateway.removeArtistDetails()
}
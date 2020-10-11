package com.benidict.domain.interactor

import com.benidict.domain.gateway.ArtistGateway

class LoadArtistDetailsUseCase(private val artistGateway: ArtistGateway){
    suspend fun invoke() = artistGateway.loadArtistDetails()
}
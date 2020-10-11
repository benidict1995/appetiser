package com.benidict.domain.interactor

import android.util.Log
import com.benidict.domain.gateway.ArtistGateway
import com.benidict.domain.model.MediaData

class LoadArtistListUseCase (private val artistGateway: ArtistGateway){
    suspend fun invoke(isRefresh: Boolean) = if(artistGateway.loadArtistListLocal().isNotEmpty()){
        Log.d("testtest", "isRefresh: $isRefresh")
        if (isRefresh){artistGateway.loadArtistList()}else{artistGateway.loadArtistListLocal()}
    }else{
        doApiCall()
    }

    private suspend fun doApiCall(): List<MediaData>{
        artistGateway.clearArtistListLocal()
        val artistLocalList = mutableListOf<MediaData>()
        artistGateway.loadArtistList().run {
            for (artist in this){
               val artistLocal = MediaData(
                   dataId = artist.dataId,
                   artistId = artist.artistId,
                   wrapperType = artist.wrapperType,
                   kind = artist.kind,
                   collectionId = artist.collectionId,
                   trackId = artist.trackId,
                   artistName = artist.artistName,
                   collectionName = artist.collectionName,
                   trackName = artist.trackName,
                   collectionCensoredName = artist.collectionCensoredName,
                   trackCensoredName = artist.trackCensoredName,
                   collectionArtistId = artist.collectionArtistId,
                   collectionArtistViewUrl = artist.collectionArtistViewUrl,
                   collectionViewUrl = artist.collectionViewUrl,
                   trackViewUrl = artist.trackViewUrl,
                   previewUrl = artist.previewUrl,
                   artworkUrl30 = artist.artworkUrl30,
                   artworkUrl60 = artist.artworkUrl60,
                   artworkUrl100 = artist.artworkUrl100,
                   collectionPrice = artist.collectionPrice,
                   trackPrice = artist.trackPrice,
                   trackRentalPrice = artist.trackRentalPrice,
                   collectionHdPrice = artist.collectionHdPrice,
                   trackHdPrice = artist.trackHdPrice,
                   trackHdRentalPrice = artist.trackHdRentalPrice,
                   releaseDate = artist.releaseDate,
                   collectionExplicitness = artist.collectionExplicitness,
                   trackExplicitness = artist.trackExplicitness,
                   discCount = artist.discCount,
                   discNumber = artist.discNumber,
                   trackCount = artist.trackCount,
                   trackNumber = artist.trackNumber,
                   trackTimeMillis = artist.trackTimeMillis,
                   country = artist.country,
                   currency = artist.currency,
                   primaryGenreName = artist.primaryGenreName,
                   contentAdvisoryRating = artist.contentAdvisoryRating,
                   shortDescription = artist.shortDescription,
                   longDescription = artist.longDescription,
                   hasITunesExtras = artist.hasITunesExtras
               )
              artistLocalList.add(artistLocal)
            }
        }
        return artistLocalList
    }

}
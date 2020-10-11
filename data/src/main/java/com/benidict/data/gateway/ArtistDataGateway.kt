package com.benidict.data.gateway

import com.benidict.data.service.LocalService
import com.benidict.data.service.RemoteService
import com.benidict.domain.dao.ArtistDao
import com.benidict.domain.exception.apiSafeCall
import com.benidict.domain.gateway.ArtistGateway
import com.benidict.domain.helper.Keys.ARTIST_DETAILS
import com.benidict.domain.helper.fromJson
import com.benidict.domain.model.MediaData
import kotlinx.serialization.json.Json

/**
 * @remoteService this param is for remote api call
 * @artistDao this param is for room database DAO
 * @localService this param is for shared preference
 **/
class ArtistDataGateway(private val remoteService: RemoteService,private val artistDao: ArtistDao, private val localService: LocalService): ArtistGateway{

    override suspend fun loadArtistList(): List<MediaData> = apiSafeCall {
        remoteService.loadMediaList().results
    }

    override suspend fun loadArtistListLocal(): List<MediaData> = artistDao.getArtistList()

    override suspend fun saveArtistListLocal(list: List<MediaData>): List<MediaData> {
        artistDao.insertArtist(list)
        return list
    }

    override suspend fun clearArtistListLocal() = artistDao.clearArtistList()

    override suspend fun saveArtistDetails(mediaData: MediaData) {
        localService.write(ARTIST_DETAILS, Json.encodeToString(MediaData.serializer(),mediaData))
    }

    override suspend fun loadArtistDetails() =
        localService.readString(ARTIST_DETAILS)?.fromJson<MediaData>()

    override suspend fun removeArtistDetails() {
        localService.deleteCache(ARTIST_DETAILS)
    }
}
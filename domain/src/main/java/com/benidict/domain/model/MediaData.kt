package com.benidict.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "artistTable")
@Serializable
data class MediaData(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "dataId")
    val dataId: Int = 0,
    @ColumnInfo(name = "artistId")
    val artistId: String?= null,
    @ColumnInfo(name = "wrapperType")
    val wrapperType: String?=null,
    @ColumnInfo(name = "kind")
    val kind: String?= null,
    @ColumnInfo(name = "collectionId")
    val collectionId: String?=null,
    @ColumnInfo(name = "trackId")
    val trackId: String?=null,
    @ColumnInfo(name = "artistName")
    val artistName: String?=null,
    @ColumnInfo(name = "collectionName")
    val collectionName: String?=null,
    @ColumnInfo(name = "trackName")
    val trackName: String?=null,
    @ColumnInfo(name = "collectionCensoredName")
    val collectionCensoredName: String?=null,
    @ColumnInfo(name = "trackCensoredName")
    val trackCensoredName :String?=null,
    @ColumnInfo(name = "collectionArtistId")
    val collectionArtistId: String?=null,
    @ColumnInfo(name = "collectionArtistViewUrl")
    val collectionArtistViewUrl: String?=null,
    @ColumnInfo(name = "collectionViewUrl")
    val collectionViewUrl: String?=null,
    @ColumnInfo(name = "trackViewUrl")
    val trackViewUrl: String?=null,
    @ColumnInfo(name = "previewUrl")
    val previewUrl: String?=null,
    @ColumnInfo(name = "artworkUrl30")
    val artworkUrl30: String?=null,
    @ColumnInfo(name = "artworkUrl60")
    val artworkUrl60: String?=null,
    @ColumnInfo(name = "artworkUrl100")
    val artworkUrl100: String?=null,
    @ColumnInfo(name = "collectionPrice")
    val collectionPrice: String?=null,
    @ColumnInfo(name = "trackPrice")
    val trackPrice: String?=null,
    @ColumnInfo(name = "trackRentalPrice")
    val trackRentalPrice: String?=null,
    @ColumnInfo(name = "collectionHdPrice")
    val collectionHdPrice: String?=null,
    @ColumnInfo(name = "trackHdPrice")
    val trackHdPrice: String?=null,
    @ColumnInfo(name = "trackHdRentalPrice")
    val trackHdRentalPrice: String?=null,
    @ColumnInfo(name = "releaseDate")
    val releaseDate: String?=null,
    @ColumnInfo(name = "collectionExplicitness")
    val collectionExplicitness: String?=null,
    @ColumnInfo(name = "trackExplicitness")
    val trackExplicitness: String?=null,
    @ColumnInfo(name = "discCount")
    val discCount: String?=null,
    @ColumnInfo(name = "discNumber")
    val discNumber: String?=null,
    @ColumnInfo(name = "trackCount")
    val trackCount: String?=null,
    @ColumnInfo(name = "trackNumber")
    val trackNumber: String?=null,
    @ColumnInfo(name = "trackTimeMillis")
    val trackTimeMillis: String?=null,
    @ColumnInfo(name = "country")
    val country: String?=null,
    @ColumnInfo(name = "currency")
    val currency: String?=null,
    @ColumnInfo(name = "primaryGenreName")
    val primaryGenreName: String?=null,
    @ColumnInfo(name = "contentAdvisoryRating")
    val contentAdvisoryRating: String?=null,
    @ColumnInfo(name = "shortDescription")
    val shortDescription: String?= null,
    @ColumnInfo(name = "longDescription")
    val longDescription: String?= null,
    @ColumnInfo(name = "hasITunesExtras")
    val hasITunesExtras: String?=null
)
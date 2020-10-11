package com.benidict.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.benidict.domain.model.MediaData

@Dao
interface ArtistDao {
    @Insert
    fun insertArtist(userLocal: List<MediaData>)

    @Query("SELECT * FROM artistTable")
    fun getArtistList(): List<MediaData>

    @Query("DELETE FROM artistTable")
    fun clearArtistList()
}
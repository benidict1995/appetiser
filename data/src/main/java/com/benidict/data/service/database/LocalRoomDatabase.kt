package com.benidict.data.service.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.benidict.domain.dao.ArtistDao
import com.benidict.domain.model.MediaData

@Database(entities = [MediaData::class], version = 1, exportSchema = false)
abstract class LocalRoomDataBase : RoomDatabase(){
    abstract fun artistDao(): ArtistDao
}
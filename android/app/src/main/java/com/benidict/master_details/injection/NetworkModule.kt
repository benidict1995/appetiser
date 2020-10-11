package com.benidict.master_details.injection

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.benidict.data.service.LocalService
import com.benidict.data.service.RemoteService
import com.benidict.data.service.database.LocalRoomDataBase
import com.benidict.master_details.BuildConfig
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {
    single { provideHttpLoggingInterceptor() }
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }
    single { provideRemoteService(get()) }
    single { provideSharedPreference(androidApplication()) }
    single { provideLocalService(get()) }
    single { provideRoomDataBase(androidContext()) }
    single { provideArtistDao(get()) }
}

private fun provideHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

private fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor) = OkHttpClient.Builder().apply {
    addInterceptor(loggingInterceptor)
}.build()

@OptIn(ExperimentalSerializationApi::class)
private fun provideRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder().apply {
    client(okHttpClient)
    baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(Json{
            ignoreUnknownKeys = true
            isLenient = true
        }.asConverterFactory("application/json".toMediaType()))
}.build()

private fun provideRemoteService(retrofit: Retrofit) = retrofit.create(RemoteService::class.java)

private fun provideLocalService(sharedPreferences: SharedPreferences) = LocalService(sharedPreferences)

private fun provideSharedPreference(application: Application): SharedPreferences
        = application.getSharedPreferences("Appetiser", Context.MODE_PRIVATE)

@OptIn(InternalCoroutinesApi::class)
private fun provideRoomDataBase(context: Context) =
    kotlinx.coroutines.internal.synchronized(LocalRoomDataBase::class) {
        Room.databaseBuilder(
            context,
            LocalRoomDataBase::class.java,
            "appetiser.db"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
    }

private fun provideArtistDao(localRoomDataBase: LocalRoomDataBase)  = localRoomDataBase.artistDao()

package com.benidict.artistdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import com.benidict.core.enums.UiState
import com.benidict.domain.interactor.ClearArtistDetailsUseCase
import com.benidict.domain.interactor.LoadArtistDetailsUseCase

/**
 * @param clearArtistDetailsUseCase use case to clear the artist details
 * @param loadArtistDetailsUseCase use case to load the artist details
 **/
class ArtistDetailsViewModel(private val clearArtistDetailsUseCase: ClearArtistDetailsUseCase,
private val loadArtistDetailsUseCase: LoadArtistDetailsUseCase) : ViewModel(){

    val doLoadArtistDetails = MutableLiveData<Boolean>()
    val loadArtistDetails = doLoadArtistDetails.switchMap {
        liveData {
            emit(UiState.Loading)
            try {
                val call = loadArtistDetailsUseCase.invoke()
                emit(UiState.Complete(call))
            }catch (e: Exception){
                emit(UiState.Error(e))
            }
        }
    }

    val doRemoveArtistDetails = MutableLiveData<Boolean>()
    val removeArtistDetails = doRemoveArtistDetails.switchMap {
        liveData {
            emit(UiState.Loading)
            try{
                val call = clearArtistDetailsUseCase.invoke()
                emit(UiState.Complete(call))
            }catch (e: Exception){
                emit(UiState.Error(e))
            }
        }
    }
}
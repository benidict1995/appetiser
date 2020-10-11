package com.benidict.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import com.benidict.core.enums.UiState
import com.benidict.domain.interactor.LoadArtistDetailsUseCase
import kotlinx.coroutines.delay


/**
 * @param loadArtistDetailsUseCase use case to load the cache data of artist details
 **/
class SplashViewModel(private val loadArtistDetailsUseCase: LoadArtistDetailsUseCase) : ViewModel(){

    val doCheckArtistDetails = MutableLiveData<Boolean>()
    val checkArtistDetails = doCheckArtistDetails.switchMap {
        liveData {
            emit(UiState.Loading)
            try{
                delay(3000)
                val call = loadArtistDetailsUseCase.invoke()
                emit(UiState.Complete(call))
            }catch (e: Exception){
                emit(UiState.Error(e))
            }
        }
    }


}
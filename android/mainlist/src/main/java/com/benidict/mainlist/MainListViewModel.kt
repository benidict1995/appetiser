package com.benidict.mainlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import com.benidict.core.enums.UiState
import com.benidict.domain.exception.ServiceException
import com.benidict.domain.interactor.LoadArtistListUseCase
import com.benidict.domain.interactor.LoadLastVisitUseCase
import com.benidict.domain.interactor.SaveArtistDetailsUseCase
import com.benidict.domain.interactor.SaveLastVisitUseCase
import com.benidict.domain.model.MediaData

/**
 * @param loadArtistListUseCase use case for getting data to api
 * @param loadLastVisitUseCase use case to load the last visit date
 * @param saveLastVisitUseCase use case to save the last visit date
 * @param saveArtistDetailsUseCase use case to save the artist details
 **/
class MainListViewModel (
    private val loadArtistListUseCase: LoadArtistListUseCase,
    private val loadLastVisitUseCase: LoadLastVisitUseCase,
    private val saveLastVisitUseCase: SaveLastVisitUseCase,
    private val saveArtistDetailsUseCase: SaveArtistDetailsUseCase
): ViewModel(){

    val doLoadArtistList = MutableLiveData<Boolean>()
    val loadArtistList = doLoadArtistList.switchMap {
        liveData {
            emit(UiState.Loading)
            try{
                val call = loadArtistListUseCase.invoke(it)
                emit(UiState.Complete(call))
            }catch (e: ServiceException){
                emit(UiState.Error(e))
            }
        }
    }

    val doLoadLastVisit = MutableLiveData<Boolean>()
    val loadLastVisit = doLoadLastVisit.switchMap {
            liveData {
                emit(UiState.Loading)
                try{
                    val call = loadLastVisitUseCase.invoke()
                    emit(UiState.Complete(call))
                }catch (e: Exception){
                    emit(UiState.Error(e))
                }
            }
        }

    val doInsertLastVisit = MutableLiveData<String>()
    val insertLastVisit = doInsertLastVisit.switchMap {
        liveData {
            emit(UiState.Loading)
            try{
                val call = saveLastVisitUseCase.invoke(it)
                emit(UiState.Complete(call))
            }catch (e: Exception){
                emit(UiState.Error(e))
            }
        }
    }

    val doSaveMediaData = MutableLiveData<MediaData>()
    val saveMediaData = doSaveMediaData.switchMap {
        liveData {
            emit(UiState.Loading)
            try{
                val call = saveArtistDetailsUseCase.invoke(it)
                emit(UiState.Complete(call))
            }catch (e: Exception){
                emit(UiState.Error(e))
            }
        }
    }

}



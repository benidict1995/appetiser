package com.benidict.master_details.injection

import com.benidict.domain.interactor.*
import org.koin.dsl.module

val usecaseModule = module {
    single { LoadArtistListUseCase(get()) }
    single { LoadLastVisitUseCase(get()) }
    single { SaveLastVisitUseCase(get()) }

    single { SaveArtistDetailsUseCase(get()) }
    single { LoadArtistDetailsUseCase(get()) }
    single { ClearArtistDetailsUseCase(get()) }
}
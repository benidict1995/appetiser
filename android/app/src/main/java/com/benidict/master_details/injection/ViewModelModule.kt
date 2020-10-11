package com.benidict.master_details.injection

import com.benidict.artistdetails.ArtistDetailsViewModel
import com.benidict.mainlist.MainListViewModel
import com.benidict.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelModule = module {
    viewModel { SplashViewModel(get()) }
    viewModel { MainListViewModel(get(), get(), get(), get()) }
    viewModel { ArtistDetailsViewModel(get(), get()) }
}
package com.benidict.master_details.injection

import com.benidict.data.gateway.ArtistDataGateway
import com.benidict.data.gateway.VisitDataGateway
import com.benidict.domain.gateway.ArtistGateway
import com.benidict.domain.gateway.VisitGateway
import org.koin.dsl.module

val gatewayModule = module {
    single { ArtistDataGateway(get(), get(), get()) as ArtistGateway  }
    single { VisitDataGateway(get()) as VisitGateway }
}
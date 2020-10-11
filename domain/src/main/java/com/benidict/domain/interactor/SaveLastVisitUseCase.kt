package com.benidict.domain.interactor

import com.benidict.domain.gateway.VisitGateway

class SaveLastVisitUseCase (private val visitGateway: VisitGateway){
    suspend fun invoke(visit: String) = visitGateway.saveLastVisitDate(visit)
}
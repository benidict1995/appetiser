package com.benidict.domain.interactor


import com.benidict.domain.gateway.VisitGateway


class LoadLastVisitUseCase(private val visitGateway: VisitGateway){
    suspend fun invoke() = visitGateway.loadLastVisitDate()
}
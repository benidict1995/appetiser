package com.benidict.domain.gateway

interface VisitGateway{
   suspend fun saveLastVisitDate(date: String)
   suspend fun loadLastVisitDate(): String
}
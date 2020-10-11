package com.benidict.data.gateway

import com.benidict.data.service.LocalService
import com.benidict.domain.gateway.VisitGateway
import com.benidict.domain.helper.Keys.LAST_VISIT_DATE

class VisitDataGateway (private val localService: LocalService): VisitGateway{
    override suspend fun saveLastVisitDate(date: String) {
        localService.write(LAST_VISIT_DATE, date)
    }

    override suspend fun loadLastVisitDate(): String = localService.readString(LAST_VISIT_DATE)!!
}
package com.benidict.domain.exception.response

data class ErrorResponse(
    val message: String?= null,
    val exception: Throwable?= null
)
package com.benidict.domain.model

import kotlinx.serialization.Serializable

/**
 * @param T it is a generic data class
 **/

@Serializable
data class DataResponse<T>(
    val resultCount: String,
    val results: T
)
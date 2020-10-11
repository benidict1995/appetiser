package com.benidict.domain.helper

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

inline fun <reified T : Any> String.fromJson() = Json.decodeFromString<T>(this)

inline fun <reified T : Any> T.toJson() = Json.encodeToString(this)
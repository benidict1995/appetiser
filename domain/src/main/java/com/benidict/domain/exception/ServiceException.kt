package com.benidict.domain.exception

import com.benidict.domain.exception.response.ErrorResponse
import java.lang.RuntimeException

open class ServiceException(
    errorResponse: ErrorResponse
): RuntimeException(errorResponse.message)
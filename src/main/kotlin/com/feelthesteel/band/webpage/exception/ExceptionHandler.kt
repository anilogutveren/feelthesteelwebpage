package com.feelthesteel.band.webpage.exception

class ExceptionHandler {
}

sealed class FTSException(cause: String) : Throwable(cause)

open class NotFoundException(cause: String) : FTSException(cause)

class SongNotFoundException(cause: String) : NotFoundException(cause)
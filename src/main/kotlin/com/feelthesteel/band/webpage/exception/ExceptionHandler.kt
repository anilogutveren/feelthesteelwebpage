package com.feelthesteel.band.webpage.exception

sealed class FTSException(cause: String) : Throwable(cause) {
    data class Unauthorized(val reason: String) : FTSException("Unauthorized Request")
    open class NotFoundException(val reason: String) : FTSException("Not Found")
}

class SongNotFoundException(cause: String) : FTSException.NotFoundException(cause)

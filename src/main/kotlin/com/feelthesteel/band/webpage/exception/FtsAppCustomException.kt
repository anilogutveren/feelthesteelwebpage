package com.feelthesteel.band.webpage.exception

class FtsAppCustomException(
    override val message: String
) : RuntimeException(message)

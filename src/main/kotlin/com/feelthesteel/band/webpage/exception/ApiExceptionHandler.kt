package com.feelthesteel.band.webpage.exception

import java.lang.Exception
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiExceptionHandler {

    private val log = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler(FtsAppCustomException::class)
    fun entityNotFound(ex: FtsAppCustomException): ResponseEntity<String> {
        log.error("Entity Not Found: ${ex.message}", ex)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entity Not Found \n${ex.message}")
    }

/*    @ExceptionHandler(FTSException::class)
    @RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE] )
    fun handleFTSExceptions(exception: Throwable) =*/
}

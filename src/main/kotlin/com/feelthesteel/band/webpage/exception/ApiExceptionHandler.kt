package com.feelthesteel.band.webpage.exception

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiExceptionHandler {

    private val log = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler(FtsAppCustomException::class)
    fun entityNotFound(ex: FtsAppCustomException): ResponseEntity<String> {
        log.error("Entity Not Found: ${ex.message}", ex)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entity Not Found \n${ex.message}")
    }
}

package com.feelthesteel.band.webpage.controller

import com.feelthesteel.band.webpage.config.security.auth.UserAuthDetailsService
import com.feelthesteel.band.webpage.entity.WebUsers
import lombok.RequiredArgsConstructor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
class UsersController(
    private val ftsWebAppUserDetailsImpl: UserAuthDetailsService
) {
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @GetMapping("/{name}", produces = ["application/json"])
    fun getAuthenticatedUser(
        @RequestHeader("X-TrackingId", required = true) trackingId: String,
        @PathVariable(value = "name", required = false) name: String
    ): ResponseEntity<UserDetails> {
        logger.info("Searching for user $name")
        return ResponseEntity.ok(ftsWebAppUserDetailsImpl.loadUserByUsername(name))
    }

    @PostMapping("/addNewUser")
    fun addUser(
        @RequestHeader("X-TrackingId", required = true) trackingId: String,
        @RequestBody webUsers: WebUsers
    ): ResponseEntity<Unit> {
        logger.info("Adding new user")
        return ResponseEntity.ok(ftsWebAppUserDetailsImpl.addNewUser(webUsers))
    }
}

package com.feelthesteel.band.webpage.controller

import com.feelthesteel.band.webpage.config.security.auth.TokenManager
import com.feelthesteel.band.webpage.config.security.request.LoginRequest
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
class LoginController(
    private val tokenManager: TokenManager
) {
    @Autowired
    private lateinit var authenticationManager: AuthenticationManager
    @PostMapping
    fun login(@RequestBody loginRequest: LoginRequest): ResponseEntity<String?>? {
        return try {
            authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            )
            ResponseEntity.ok(tokenManager.generateToken(loginRequest.getUsername()))
        } catch (e: Exception) {
            throw e
        }
    }
}

package com.feelthesteel.band.webpage.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AuthController {

    @Value("classpath:/static/secure.html")
    private lateinit var securePage: Resource

    @GetMapping("/auth")
    fun main(token: OAuth2AuthenticationToken): String {
        println(token.principal)
        return securePage.toString()
    }
}

package com.feelthesteel.band.webpage.config.security.request

class LoginRequest {

    private var username: String? = null

    private var password: String? = null

    fun getUsername(): String? {
        return username
    }

    fun getPassword(): String? {
        return password
    }
}

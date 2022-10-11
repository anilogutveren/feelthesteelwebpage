package com.feelthesteel.band.webpage.dto

class LoginRequest {
    var username: String?
    var password: String?

    constructor(username: String?, password: String?) {
        this.username = username
        this.password = password
    }
}

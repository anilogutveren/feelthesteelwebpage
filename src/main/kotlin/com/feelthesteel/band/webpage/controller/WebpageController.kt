package com.feelthesteel.band.webpage.controller

import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
class WebpageController {

    @GetMapping("/hello")
    fun index(): String? {
        return "hello world!"
    }
}

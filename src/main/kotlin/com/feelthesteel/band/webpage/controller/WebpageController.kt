package com.feelthesteel.band.webpage.controller

import com.feelthesteel.band.webpage.service.WebpageService
import lombok.RequiredArgsConstructor
import org.springframework.core.io.Resource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
class WebpageController(
    private val webpageService: WebpageService
) {
    @GetMapping("/")
    fun showMainPage(): ResponseEntity<Resource> {
        return ResponseEntity.ok(webpageService.getPage())
    }
}

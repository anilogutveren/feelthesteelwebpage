package com.feelthesteel.band.webpage.controller

import com.feelthesteel.band.webpage.service.IWebpageService
import lombok.RequiredArgsConstructor
import org.springframework.core.io.Resource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = ["http://localhost:8082"])
class LoginController(
    private val webpageService: IWebpageService,
    private val request: HttpServletRequest
) {
    @GetMapping("/login")
    fun login(): ResponseEntity<Resource> {
        return ResponseEntity.ok(webpageService.getSecurePage())
    }
}

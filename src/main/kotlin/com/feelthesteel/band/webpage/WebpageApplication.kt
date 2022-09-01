package com.feelthesteel.band.webpage

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@SpringBootApplication
class WebpageApplication

fun main(args: Array<String>) {
	runApplication<WebpageApplication>(*args)
}

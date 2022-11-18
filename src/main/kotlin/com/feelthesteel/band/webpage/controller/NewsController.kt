package com.feelthesteel.band.webpage.controller

import com.feelthesteel.band.webpage.entity.NewsEntity
import com.feelthesteel.band.webpage.service.BlogPageService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/news")
@CrossOrigin(origins = ["*"])
class NewsController(private val blogPageService: BlogPageService) {

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @GetMapping("/latest")
    fun getNews(
        @RequestHeader("Access-Control-Allow-Origin") origin: String
    ): ResponseEntity<List<NewsEntity>> {
        logger.info("Fetching the latest news")
        return ResponseEntity.ok(blogPageService.getAllNews())
    }
}

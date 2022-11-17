package com.feelthesteel.band.webpage.controller

import com.feelthesteel.band.webpage.entity.NewsEntity
import com.feelthesteel.band.webpage.service.BlogPageService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/news")
class NewsController(private val blogPageService: BlogPageService) {

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @GetMapping("/latest")
    fun getNews(): ResponseEntity<List<NewsEntity>> {
        logger.info("Fetching the latest news")
        return ResponseEntity.ok(blogPageService.getAllNews())
    }
}

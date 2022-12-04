package com.feelthesteel.band.webpage.clients

import com.feelthesteel.band.webpage.config.BlogPageClientProperties
import com.feelthesteel.band.webpage.entity.NewsEntity
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class BlogPageClient(
    private val blogPageClientProperties: BlogPageClientProperties
) {
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)
    private val restTemplate = RestTemplate()

    companion object {
        private const val target = "BlogPage"
    }

    @CircuitBreaker(name = "personalpage", fallbackMethod = "fallbackGetAllLatestNews")
    suspend fun getAllLatestNews(): List<NewsEntity> {
        val url = blogPageClientProperties.basePath + "/news/allNews"

        val headers = HttpHeaders()
        headers[HttpHeaders.ACCEPT] = MediaType.APPLICATION_JSON_VALUE

        val response = withContext(Dispatchers.IO) {
            restTemplate.exchange(url, HttpMethod.GET, HttpEntity<Any>(headers), Array<NewsEntity>::class.java)
        }
        return listOf(*response.body!!)
    }

    fun fallbackGetAllLatestNews(throwable: Throwable): List<NewsEntity> {
        logger.error("Error= $throwable")
        return listOf(NewsEntity(1, "FallBackNews Error"))
    }
}

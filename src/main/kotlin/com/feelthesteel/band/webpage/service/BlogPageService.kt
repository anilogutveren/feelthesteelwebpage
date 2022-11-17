package com.feelthesteel.band.webpage.service

import com.feelthesteel.band.webpage.clients.BlogPageClient
import com.feelthesteel.band.webpage.entity.NewsEntity
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class BlogPageService(
    private val blogPageClient: BlogPageClient
) {

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    fun getAllNews(): List<NewsEntity> {
        return try {
            runBlocking {
                val myHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
                    println("Exception handled: ${throwable.localizedMessage}")
                }

                val newsDeferred = async {
                    blogPageClient.getAllLatestNews()
                }

                val news = newsDeferred.await()
                logger.info(news.toString())
                return@runBlocking news
            }
        } catch (e: Exception) {
            logger.warn("Caught Timeout Exception ${e.localizedMessage}")
            return emptyList()
        }
    }
}

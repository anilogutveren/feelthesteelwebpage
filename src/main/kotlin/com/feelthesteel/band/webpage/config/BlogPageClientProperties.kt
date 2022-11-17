package com.feelthesteel.band.webpage.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("clients.blogpage")
class BlogPageClientProperties {
    lateinit var basePath: String
}
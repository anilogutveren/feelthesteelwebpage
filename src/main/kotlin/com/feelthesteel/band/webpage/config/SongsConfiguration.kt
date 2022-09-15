package com.feelthesteel.band.webpage.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("songs")
class SongsConfiguration {
    var ownedsongs: List<String> = emptyList()
    var coveredsongs: List<String> = emptyList()
}

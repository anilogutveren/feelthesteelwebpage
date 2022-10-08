package com.feelthesteel.band.webpage.service.impl

import com.feelthesteel.band.webpage.entity.SongEntity
import com.feelthesteel.band.webpage.exception.FtsAppCustomException
import com.feelthesteel.band.webpage.repository.SongsRepository
import com.feelthesteel.band.webpage.service.ISongsService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class SongsServiceImpl(val repository: SongsRepository) : ISongsService {

    val logger: Logger = LoggerFactory.getLogger(this.javaClass)
    override fun saveSongs(song: SongEntity): SongEntity {
        logger.info("Song $song will be saved")
        return repository.save(song) //  ?: throw FtsAppCustomException("Song $song cannot be registered")
    }

    override fun findCoveredSongs(isCovered: Boolean): SongEntity {
        logger.info("Please wait. Song are listed soon...")
        return repository.findSongByIsCovered(isCovered) ?: throw FtsAppCustomException("No song is found under given name and instrument")
    }

    override fun deleteAllSongs() {
        logger.info("All Songs are deleted")
        repository.deleteAll()
    }
}

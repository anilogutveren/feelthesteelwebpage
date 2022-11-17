package com.feelthesteel.band.webpage.service.impl

import com.feelthesteel.band.webpage.dto.SongDto
import com.feelthesteel.band.webpage.entity.SongEntity
import com.feelthesteel.band.webpage.exception.SongNotFoundException
import com.feelthesteel.band.webpage.repository.SongsRepository
import com.feelthesteel.band.webpage.service.SongsService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SongsServiceImpl(val songsRepository: SongsRepository) : SongsService {

    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Transactional
    override fun saveSongs(songDto: SongDto): SongDto {
        logger.info("Song $songDto will be saved")
        val songEntity = songsRepository.save(songDto.toSongEntity())

        songDto.id = songEntity.id
        songDto.songName = songEntity.songName
        songDto.songsGenre = songEntity.songsGenre
        songDto.songsYear = songEntity.songsYear
        songDto.isCovered = songEntity.isCovered

        return songDto
    }

    override fun findCoveredSongs(isCovered: Boolean): SongEntity {
        logger.info("Please wait. Song are listed soon...")
        return songsRepository.findSongByIsCovered(isCovered) ?: throw SongNotFoundException("No song is found under given name and instrument")
    }

    override fun deleteAllSongs() {
        logger.info("All Songs are deleted")
        songsRepository.deleteAll()
    }

    fun SongDto.toSongEntity() = SongEntity(
        id = this.id,
        songName = this.songName,
        songsGenre = this.songsGenre,
        songsYear = this.songsYear,
        isCovered = this.isCovered
    )
}

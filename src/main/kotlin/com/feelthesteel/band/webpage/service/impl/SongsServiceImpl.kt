package com.feelthesteel.band.webpage.service.impl

import com.feelthesteel.band.webpage.dto.SongDto
import com.feelthesteel.band.webpage.entity.SongEntity
import com.feelthesteel.band.webpage.exception.SongNotFoundException
import com.feelthesteel.band.webpage.repository.SongsRepository
import com.feelthesteel.band.webpage.service.ISongsService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SongsServiceImpl(val songsRepository: SongsRepository) : ISongsService {

    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Transactional
    override fun saveSongs(songDto: SongDto): SongDto {
        logger.info("Song $songDto will be saved")
        val songEntity = songDto.toSongEntity()
        songsRepository.save(songEntity)
        songDto.id = songEntity.id
        songDto.songName = songEntity.songname
        songDto.songsGenre = songEntity.songgenre
        songDto.songsYear = songEntity.songyear
        songDto.isCovered = songEntity.isCovered

        return songDto
    }

    override fun findCoveredSongs(iscovered: Boolean): List<SongDto> {
        TODO("Not yet implemented")
    }

    /*    override fun findCoveredSongs(isCovered: Boolean): List<SongDto> {
            logger.info("Please wait. Song will be listed soon...")
            return songsRepository.findSongByIsCovered(isCovered) ?: throw SongNotFoundException("No song is found under given name")
        }*/

    override fun deleteAllSongs() {
        logger.info("All Songs are deleted")
        songsRepository.deleteAll()
    }

    fun SongDto.toSongEntity() = SongEntity(
        id = this.id,
        songname = this.songName,
        songgenre = this.songsGenre,
        songyear = this.songsYear,
        isCovered = this.isCovered
    )
}

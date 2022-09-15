package com.feelthesteel.band.webpage.service.impl

import com.feelthesteel.band.webpage.entity.songs.Song
import com.feelthesteel.band.webpage.exception.FtsAppCustomException
import com.feelthesteel.band.webpage.repo.SongsRepository
import com.feelthesteel.band.webpage.service.ISongsService
import org.springframework.stereotype.Service

@Service
class SongsServiceImpl(val repository: SongsRepository) : ISongsService {
    override fun saveSongs(song: Song) {
        repository.save(song)
    }

    override fun findCoveredSongs(isCoveredSong: Boolean): Song {
        return repository.findByIsCoveredSong(isCoveredSong) ?: throw FtsAppCustomException("No song is found under given name and instrument")
    }

    override fun deleteAllSongs() {
        repository.deleteAll()
    }
}

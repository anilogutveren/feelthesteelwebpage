package com.feelthesteel.band.webpage.service

import com.feelthesteel.band.webpage.dto.SongDto
import com.feelthesteel.band.webpage.entity.SongEntity

interface SongsService {
    fun saveSongs(song: SongDto): SongDto
    fun findCoveredSongs(isCovered: Boolean): SongEntity
    fun deleteAllSongs()
}

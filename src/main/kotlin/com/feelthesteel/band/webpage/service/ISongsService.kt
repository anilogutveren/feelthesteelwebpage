package com.feelthesteel.band.webpage.service

import com.feelthesteel.band.webpage.dto.SongDto
import com.feelthesteel.band.webpage.entity.SongEntity

interface ISongsService {
    fun saveSongs(song: SongDto): SongDto
    fun findCoveredSongs(iscovered: Boolean): List<SongDto>
    fun deleteAllSongs()
}

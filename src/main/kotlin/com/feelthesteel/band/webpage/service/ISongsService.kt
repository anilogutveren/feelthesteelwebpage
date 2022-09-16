package com.feelthesteel.band.webpage.service

import com.feelthesteel.band.webpage.entity.songs.SongEntity

interface ISongsService {
    fun saveSongs(songs: SongEntity): SongEntity
    fun findCoveredSongs(isCovered: Boolean): SongEntity
    fun deleteAllSongs()
}
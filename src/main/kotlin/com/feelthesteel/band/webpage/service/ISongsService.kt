package com.feelthesteel.band.webpage.service

import com.feelthesteel.band.webpage.entity.songs.Song

interface ISongsService {
    fun saveSongs(songs: Song)
    fun findCoveredSongs(isCoveredSong: Boolean): Song
    fun deleteAllSongs()
}

package com.feelthesteel.band.webpage.repo

import com.feelthesteel.band.webpage.entity.songs.Song
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SongsRepository : JpaRepository<Song, Long> {
    fun findByIsCoveredSong(isCoveredSong: Boolean): Song?
}

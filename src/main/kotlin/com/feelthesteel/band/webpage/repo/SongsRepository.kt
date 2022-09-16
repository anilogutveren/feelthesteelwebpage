package com.feelthesteel.band.webpage.repo

import com.feelthesteel.band.webpage.entity.songs.SongEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SongsRepository : JpaRepository<SongEntity, Long> {
    fun findSongByIsCovered(isCovered: Boolean): SongEntity?
}

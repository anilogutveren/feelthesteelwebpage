package com.feelthesteel.band.webpage.repository

import com.feelthesteel.band.webpage.dto.SongDto
import com.feelthesteel.band.webpage.entity.SongEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SongsRepository : JpaRepository<SongEntity, Long> {
    fun findSongByIsCovered(isCovered: Boolean): List<SongDto>?
}

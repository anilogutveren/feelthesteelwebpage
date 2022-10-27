package com.feelthesteel.band.webpage.repository

import com.feelthesteel.band.webpage.entity.MusicianEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MusicianRepository : JpaRepository<MusicianEntity, Long> {
    fun findMusicianByName(name: String): MusicianEntity?
}

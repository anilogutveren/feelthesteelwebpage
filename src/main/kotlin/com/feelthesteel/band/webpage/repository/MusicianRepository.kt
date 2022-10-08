package com.feelthesteel.band.webpage.repository

import com.feelthesteel.band.webpage.model.Instrument
import com.feelthesteel.band.webpage.entity.MusicianEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MusicianRepository : JpaRepository<MusicianEntity, Long> {
    fun findMusicianByNameAndInstrument(name: String, instrument: Instrument): MusicianEntity?
}

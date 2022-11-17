package com.feelthesteel.band.webpage.service

import com.feelthesteel.band.webpage.dto.MusicianDto
import com.feelthesteel.band.webpage.entity.MusicianEntity

interface MusicianService {
    fun saveMusician(musicianEntity: MusicianEntity)
    fun saveMultipleMusicians(musicianEntities: List<MusicianEntity>)
    fun deleteAllMusicians()
    fun findMusicianByName(name: String): MusicianDto
    fun getAllMusicians(): MutableList<MusicianEntity>
}

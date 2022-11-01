package com.feelthesteel.band.webpage.service

import com.feelthesteel.band.webpage.dto.MusicianDto
import com.feelthesteel.band.webpage.entity.MusicianEntity

interface IMusicianService {
    fun saveMusician(musicianDto: MusicianDto)
    fun saveMultipleMusicians(musicianDtos: List<MusicianDto>)
    fun deleteAllMusicians()
    fun findMusicianByName(name: String): MusicianDto
    fun getAllMusicians(): MutableList<MusicianDto>
    fun updateMusician(musicianDto: MusicianDto)
}

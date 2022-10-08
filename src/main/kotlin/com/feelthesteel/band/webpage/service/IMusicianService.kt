package com.feelthesteel.band.webpage.service

import com.feelthesteel.band.webpage.entity.MusicianEntity
import com.feelthesteel.band.webpage.model.Instrument

interface IMusicianService {
    fun saveMusician(musicianEntity: MusicianEntity)
    fun saveMultipleMusicians(musicianEntities: List<MusicianEntity>)
    fun deleteAllMusicians()
    fun findMusicianByNameAndInstrument(name: String, instrument: Instrument): MusicianEntity
    fun getAllMusicians(): MutableList<MusicianEntity>
}

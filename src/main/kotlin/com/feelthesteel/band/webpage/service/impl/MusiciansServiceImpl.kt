package com.feelthesteel.band.webpage.service.impl

import com.feelthesteel.band.webpage.entity.Instrument
import com.feelthesteel.band.webpage.entity.MusicianEntity
import com.feelthesteel.band.webpage.repo.MusicianRepository
import com.feelthesteel.band.webpage.service.IMusicianService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class MusiciansServiceImpl(val repository: MusicianRepository) : IMusicianService {

    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    override fun saveMusician(musicianEntity: MusicianEntity) {
        repository.save(musicianEntity)
        logger.info("Musician is saved")
    }

    override fun deleteAllMusicians() {
        repository.deleteAll()
        logger.info("All musicians are deleted")
    }

    override fun findMusicianByNameAndInstrument(name: String, instrument: Instrument): MusicianEntity {
        return repository.findMusicianByNameAndInstrument(name, instrument)
            ?: throw IllegalStateException("No musician is found under given name and instrument")
        logger.info("Musician is found")
    }

    override fun getAllMusicians(): MutableList<MusicianEntity> {
        return repository.findAll()
        logger.info("All musicians are listed")
    }
}

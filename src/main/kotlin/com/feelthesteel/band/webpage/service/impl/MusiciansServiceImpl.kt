package com.feelthesteel.band.webpage.service.impl

import com.feelthesteel.band.webpage.entity.MusicianEntity
import com.feelthesteel.band.webpage.exception.FtsAppCustomException
import com.feelthesteel.band.webpage.model.Instrument
import com.feelthesteel.band.webpage.repository.MusicianRepository
import com.feelthesteel.band.webpage.service.IMusicianService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class MusiciansServiceImpl(val repository: MusicianRepository) : IMusicianService {

    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    override fun saveMusician(musicianEntity: MusicianEntity) {
        logger.info("Musician is saved")
        repository.save(musicianEntity)
    }

    override fun saveMultipleMusicians(musicianEntities: List<MusicianEntity>) {
        logger.info("Musicians are saved")
        repository.saveAll(musicianEntities)
    }

    override fun deleteAllMusicians() {
        logger.info("All musicians are deleted")
        repository.deleteAll()
    }

    override fun findMusicianByNameAndInstrument(name: String, instrument: Instrument): MusicianEntity {
        logger.info("Musician will be found")
        return repository.findMusicianByNameAndInstrument(name, instrument)
            ?: throw FtsAppCustomException("No musician is found under given name and instrument")
    }

    override fun getAllMusicians(): MutableList<MusicianEntity> {
        logger.info("All musicians will be listed")
        return repository.findAll()
    }
}

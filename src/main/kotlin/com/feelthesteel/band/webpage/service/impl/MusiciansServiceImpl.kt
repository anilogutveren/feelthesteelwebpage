package com.feelthesteel.band.webpage.service.impl

import com.feelthesteel.band.webpage.dto.MusicianDto
import com.feelthesteel.band.webpage.entity.MusicianEntity
import com.feelthesteel.band.webpage.entity.mapper.MusicianEntitytoDtoMapper.toMusicianDto
import com.feelthesteel.band.webpage.exception.FtsAppCustomException
import com.feelthesteel.band.webpage.repository.MusicianRepository
import com.feelthesteel.band.webpage.service.MusicianService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class MusiciansServiceImpl(val repository: MusicianRepository) : MusicianService {

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

    override fun findMusicianByName(name: String): MusicianDto {
        return repository.findMusicianByName(name)?.toMusicianDto()
            ?: throw FtsAppCustomException("No musician is found under given name and instrument")
    }

    override fun getAllMusicians(): MutableList<MusicianEntity> {
        logger.info("All musicians will be listed")
        return repository.findAll()
    }
}

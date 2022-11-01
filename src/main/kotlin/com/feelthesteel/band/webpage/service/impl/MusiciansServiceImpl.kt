package com.feelthesteel.band.webpage.service.impl

import com.feelthesteel.band.webpage.dto.MusicianDto
import com.feelthesteel.band.webpage.entity.MusicianEntity
import com.feelthesteel.band.webpage.entity.mapper.MusicianEntitytoDtoMapper.toMusicianDto
import com.feelthesteel.band.webpage.exception.FTSException
import com.feelthesteel.band.webpage.exception.FtsAppCustomException
import com.feelthesteel.band.webpage.repository.MusicianRepository
import com.feelthesteel.band.webpage.service.IMusicianService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MusiciansServiceImpl(val repository: MusicianRepository) : IMusicianService {

    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Transactional
    override fun saveMusician(musicianDto: MusicianDto) {
        logger.info("Musician is going to be saved")
        repository.save(musicianDto.toMusicianEntity())
    }

    override fun saveMultipleMusicians(musicianDtos: List<MusicianDto>) {
        logger.info("Musicians are going to be saved")
        repository.saveAll(musicianDtos.map { it.toMusicianEntity() })
    }

    override fun deleteAllMusicians() {
        logger.info("All musicians are deleted")
        repository.deleteAll()
    }

    override fun findMusicianByName(name: String): MusicianDto {
        return repository.findMusicianByName(name)?.toMusicianDto()
            ?: throw FtsAppCustomException("No musician is found under given name and instrument")
    }

    override fun getAllMusicians(): MutableList<MusicianDto> {
        logger.info("All musicians will be listed")
        return repository.findAll().map { it.toMusicianDto() }.toMutableList()
    }

    @Transactional
    override fun updateMusician(musicianDto: MusicianDto) {
        val musicianEntity = repository.findMusicianByName(musicianDto.name) ?: throw FTSException.NotFoundException("No Musicians found to update")
        musicianEntity.equipments = musicianDto.equipments
        listDiff(musicianDto, musicianEntity)
        repository.save(musicianEntity)
    }

    private fun MusicianDto.toMusicianEntity() = MusicianEntity(
        id = this.id,
        name = this.name,
        equipments = this.equipments
    )

    private fun <T> listDiff(x: T, y: T): Int {
        val diff = x.toString().compareTo(y.toString())
        println("Musician entity is changed with value: $diff")
        return diff
    }
}

package com.feelthesteel.band.webpage.service.impl

import com.feelthesteel.band.webpage.RepositoryTest
import com.feelthesteel.band.webpage.dto.MusicianDto
import com.feelthesteel.band.webpage.entity.EquipmentEntity
import com.feelthesteel.band.webpage.model.Instrument
import com.feelthesteel.band.webpage.repository.MusicianRepository
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

@RepositoryTest
internal class MusiciansServiceImplIntegrationTest {

    @Autowired
    private lateinit var repository: MusicianRepository

    @Autowired
    private lateinit var service: MusiciansServiceImpl

    @BeforeEach
    fun init() {
        service = MusiciansServiceImpl(repository)
    }

    @Test
    fun `test save a musician`() {
        val newEquipmentEntity = EquipmentEntity(1L, Instrument.DRUM, null)

        val newMusicianDto = MusicianDto(1L, "testMusicianName", setOf(newEquipmentEntity))

        service.saveMusician(newMusicianDto)
        val listOfMusicians = service.getAllMusicians()

        Assert.assertEquals(listOfMusicians.size, 1)
    }

    @Test
    fun saveMultipleMusicians() {
    }

    @Test
    fun deleteAllMusicians() {
    }

    @Test
    fun findMusicianByName() {
    }

    @Test
    fun getAllMusicians() {
    }
}

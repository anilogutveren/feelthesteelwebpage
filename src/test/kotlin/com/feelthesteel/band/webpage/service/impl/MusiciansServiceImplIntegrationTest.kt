package com.feelthesteel.band.webpage.service.impl

import com.feelthesteel.band.webpage.entity.EquipmentEntity
import com.feelthesteel.band.webpage.entity.MusicianEntity
import com.feelthesteel.band.webpage.model.Instrument
import com.feelthesteel.band.webpage.repository.MusicianRepository
import com.feelthesteel.band.webpage.service.IMusicianService
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class MusiciansServiceImplIntegrationTest {

    @Autowired
    private lateinit var repository: MusicianRepository

    @Autowired
    private lateinit var service: IMusicianService

    @BeforeEach
    fun init() {
        service = MusiciansServiceImpl(repository)
    }

    @Test
    fun `test save a musician`() {
        val newEquipmentEntity = EquipmentEntity(1L, Instrument.DRUM, null)

        val newMusicianEntity = MusicianEntity(1L, "testMusicianName", setOf(newEquipmentEntity))

        service.saveMusician(newMusicianEntity)
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

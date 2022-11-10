package com.feelthesteel.band.webpage.service.impl

import com.feelthesteel.band.webpage.entity.MusicianEntity
import com.feelthesteel.band.webpage.repository.MusicianRepository
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
internal class MusiciansServiceImplIntegrationTest {

    @Autowired
    private lateinit var repository: MusicianRepository

    private lateinit var service: MusiciansServiceImpl

    @BeforeEach
    fun init() {
        service = MusiciansServiceImpl(repository)
    }

    @Test
    fun `test register a new musician`() {
        val newMusicianEntity = MusicianEntity(2L, "testMusicianName2", "DRUMS")

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

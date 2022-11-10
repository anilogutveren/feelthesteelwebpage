/*
package com.feelthesteel.band.webpage.service.impl

import com.feelthesteel.band.webpage.config.security.ProjectSecurityConfig
import com.feelthesteel.band.webpage.config.security.Roles
import com.feelthesteel.band.webpage.config.security.auth.UserAuthDetailsService
import com.feelthesteel.band.webpage.controller.LoginController
import com.feelthesteel.band.webpage.entity.EquipmentEntity
import com.feelthesteel.band.webpage.entity.MusicianEntity
import com.feelthesteel.band.webpage.entity.WebUsers
import com.feelthesteel.band.webpage.model.Musician
import com.feelthesteel.band.webpage.repository.MusicianRepository
import com.feelthesteel.band.webpage.repository.UsersRepository
import com.feelthesteel.band.webpage.service.IMusicianService
import com.feelthesteel.band.webpage.service.impl.auth.FtsWebAppUserDetailsImpl
import org.flywaydb.core.Flyway
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder

@SpringBootTest
@ExtendWith(MockitoExtension::class)
internal class MusiciansServiceImplUnitTest() {

    @Autowired
    private val flyway: Flyway? = null

    @MockBean
    private lateinit var projectSecurityConfig: ProjectSecurityConfig

    @Mock
    private lateinit var repository: MusicianRepository

    @InjectMocks
    private lateinit var service: IMusicianService

    @Mock
    private lateinit var equipmentEntity: EquipmentEntity

    @MockBean
    private lateinit var loginController: LoginController

    @MockBean
    private lateinit var usersRepository: UsersRepository

    @Qualifier("noops")
    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    @Mock
    @Qualifier("ftsWebAppUserDetailsImpl")
    private lateinit var userDetailsService: UserDetailsService

    @BeforeEach
    fun init() {
        service = MusiciansServiceImpl(repository)
        flyway?.migrate()
        userDetailsService = FtsWebAppUserDetailsImpl(usersRepository, passwordEncoder)
    }

    @Test
    fun `test save a musician`() {
        val newMusicianEntity = MusicianEntity(1L, "testMusicianName", setOf(equipmentEntity))
        val musicianMock: Musician = Mockito.mock(Musician::class.java)
        val webUser = WebUsers(1, "abc", "xyz", com.feelthesteel.band.webpage.entity.Roles())

        `when`(musicianMock.name).thenReturn("testMusicianName")
        `when`(usersRepository.save(ArgumentMatchers.any(WebUsers::class.java))).thenReturn(webUser)
        `when`(usersRepository.findByUsername(ArgumentMatchers.any(String::class.java))).thenReturn(webUser)
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
*/

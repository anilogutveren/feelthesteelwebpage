/*
package com.feelthesteel.band.webpage.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.feelthesteel.band.webpage.config.security.ProjectSecurityConfig
import com.feelthesteel.band.webpage.config.security.auth.TokenManager
import com.feelthesteel.band.webpage.config.security.auth.UserAuthDetailsService
import com.feelthesteel.band.webpage.service.impl.MusiciansServiceImpl
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc

@ExtendWith(SpringExtension::class, MockitoExtension::class)
@WebMvcTest(controllers = [MusicianController::class])
@Import(ProjectSecurityConfig::class, UserAuthDetailsService::class, TokenManager::class)
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("test")
internal class MusicianControllerTest() {

    private val CONTENT_TYPE = "application/json"
    private val TRACKING_ID = "abcde"

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var musiciansServiceImpl: MusiciansServiceImpl

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    fun getAllMusicians() {
    }

    @Test
    fun getMusicianByName() {
    }

    @Test
    fun deleteAllMusicians() {
    }

    @Test
    fun registerNewMusician() {
    }

    @Test
    fun registerNewMusicians() {
    }
}
*/

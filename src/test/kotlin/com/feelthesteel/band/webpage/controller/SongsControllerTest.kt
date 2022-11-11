package com.feelthesteel.band.webpage.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.feelthesteel.band.webpage.config.security.ProjectSecurityConfig
import com.feelthesteel.band.webpage.config.security.auth.TokenManager
import com.feelthesteel.band.webpage.config.security.auth.UserAuthDetailsService
import com.feelthesteel.band.webpage.dto.SongDto
import com.feelthesteel.band.webpage.entity.SongEntity
import com.feelthesteel.band.webpage.service.impl.SongsServiceImpl
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@ExtendWith(SpringExtension::class, MockitoExtension::class)
@WebMvcTest(controllers = [SongsController::class])
@Import(ProjectSecurityConfig::class, UserAuthDetailsService::class, TokenManager::class)
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("test")
internal class SongsControllerTest {

    private val CONTENT_TYPE = "application/json"
    private val TRACKING_ID = "abcde"

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var songsServiceImpl: SongsServiceImpl

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    fun addNewSong() {
        val songDto = SongDto(1, "testSong", "testGenre", 1987, true)

        val actions: ResultActions = mockMvc.perform(
            MockMvcRequestBuilders.post("/songs/addNewSong")
                .header("X-TrackingId", TRACKING_ID)
                .contentType(CONTENT_TYPE)
                .content(objectMapper.writeValueAsString(songDto))
        )

        val captor = argumentCaptor<SongDto>()
        verify(songsServiceImpl, times(1)).saveSongs(captor.capture())
        assertThat(captor.allValues.any { it.songName == "testSong" })
        actions.andExpect(MockMvcResultMatchers.status().isOk)
    }

    @Test
    fun getCoveredSongs() {
        val songDto = SongEntity(1, "testSong", "testGenre", 1987, true)
        `when`(songsServiceImpl.findCoveredSongs(true)).thenReturn(songDto)

        val mvcResult: MvcResult = mockMvc.perform(
            MockMvcRequestBuilders.get("/songs/coveredSongs/true")
                .header("X-TrackingId", TRACKING_ID)
                .contentType(CONTENT_TYPE)
        ).andReturn()

        val responseBody = mvcResult.response.contentAsString
        verify(songsServiceImpl, times(1)).findCoveredSongs(true)
        assertThat(objectMapper.writeValueAsString(songDto)).isEqualToIgnoringWhitespace(responseBody)
    }

    @Test
    fun deleteAllSongs() {
    }
}

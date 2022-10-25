package com.feelthesteel.band.webpage.controller

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc

@ExtendWith(SpringExtension::class)
@WebMvcTest
internal class MusicianControllerTest(@Autowired val mockMvc: MockMvc) {

    @BeforeEach
    fun setUp() {
    }

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

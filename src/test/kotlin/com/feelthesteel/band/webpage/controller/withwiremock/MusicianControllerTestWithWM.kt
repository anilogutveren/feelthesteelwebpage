package com.feelthesteel.band.webpage.controller.withwiremock

import com.feelthesteel.band.webpage.service.impl.MusiciansServiceImpl
import com.github.jenspiegsa.wiremockextension.ManagedWireMockServer.with
import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.aResponse
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import com.github.tomakehurst.wiremock.junit5.WireMockExtension
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@ExtendWith(WireMockExtension::class)
internal class MusicianControllerTestWithWM() {

    val wiremock: WireMockServer = with(WireMockConfiguration.wireMockConfig().dynamicPort())

    @Autowired
    private lateinit var musiciansServiceImpl: MusiciansServiceImpl

    @BeforeEach
    fun setUp() {
        wiremock.start()
    }

    @AfterEach
    fun cleanUp() {
        wiremock.stop()
    }

    @Test
    fun getAllMusicians() {
        // Stubbing WireMock
        stubFor(
            get(urlEqualTo("/musicians"))
                .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody("Hello World!"))
        )

        // We're asserting if WireMock responded properly
        assertThat(this.musiciansServiceImpl.getAllMusicians()).isNotNull
    }
}
